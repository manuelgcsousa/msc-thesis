const fetch = require('isomorphic-fetch');
const fs = require('fs');
const jsonfile = require('jsonfile');
const Dropbox = require('dropbox').Dropbox;

const data = (__dirname + '/../data');

const dbx = new Dropbox({
	accessToken: process.env.DROPBOX_TOKEN,
	fetch: fetch
});


/* Uploads a new feedback file to dropbox. */
function upload() {
    fs.readFile(data + '/feedback.dbx.json', (err, data) => {
        dbx
            .filesUpload({
                path: '/feedback.json',
                contents: data,
                mode: 'overwrite'
            })
            .then(res => {
                console.log('> \'feedback.json\' uploaded to Dropbox [' + new Date() + ']');	
            })
            .catch(err => {
                console.log('> Error while uploading \'feedback.json\' to Dropbox!');
            });
    });
}

exports.saveFeedback = function() {
	dbx
		.filesDownload({ path: '/feedback.json' })
		.then(res => {
			console.log('> \'feedback.json\' downloaded from Dropbox [' + new Date() + ']');
            // Writes downloaded binary data to a file.
            fs.writeFileSync(data + '/feedback.dbx.json', res.fileBinary, 'binary');

            // Read feedbacks (dropbox and local) to JSON objects.
            const feedback_dbx   = jsonfile.readFileSync(data + '/feedback.dbx.json');
            const feedback_local = jsonfile.readFileSync(data + '/feedback.json');
           
            // Add new feedbacks to the dropbox object.
            for (i in feedback_local) {
                feedback_dbx.push(feedback_local[i]);
            }
            jsonfile.writeFileSync(data + '/feedback.dbx.json', feedback_dbx);

            // Upload updated feedbacks to dropbox.
            upload();
            
            // Clean the local feedback file.
            let empty = [];
            jsonfile.writeFileSync(data + '/feedback.json', empty);
		})
		.catch(err => {
			console.log('> Error while downloading \'feedback.json\' from Dropbox!');
		});
}
