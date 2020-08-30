var express    = require('express');
var router     = express.Router();
const path     = require('path');
const jsonfile = require('jsonfile');

const feedback = (__dirname + '/../data/feedback.json');


// home page
router.get('/', function(req, res, next) {
    res.render('home', { title: 'Home' });
});

// tool page
router.get('/lyntax/information', (req, res, next) => {
    res.render('lyntax', { title: 'lyntax' });
});

// download tool page
router.get('/lyntax/download', (req, res, next) => {
    res.render('download', { title: 'download '});
});

// download tool
router.get('/lyntax/download/:type', function(req, res, next) {
    const type = req.params.type;

    if (type === 'cli') {
        res.download(path.join(__dirname, '../_download/lyntax-cli.zip'));
    } else if (type === 'gui') {
		res.download(path.join(__dirname, '../_download/lyntax-gui.zip'));
    } else {
        res.render('download', { title: 'download' });
    }
});

// dsl page
router.get('/dsl', (req, res, next) => {
    res.render('dsl', { title: 'dsl' });
});

// feedback page
router.get('/feedback', (req, res, next) => {
    res.render('feedback', { title: 'feedback' });
});

// process new feedback
router.post('/feedback', (req, res, next) => {
    const res_feedback = JSON.parse(JSON.stringify(req.body));
    res_feedback['data'] = new Date();

    jsonfile.readFile(feedback, (err, obj) => {
        if (!err) {
            obj.push(res_feedback);

            jsonfile.writeFile(feedback, obj, (err) => {
                if (err)
                    console.error(err);
            });
        } else { 
            console.error(err);
        }
    });
    
    res.redirect('/feedback');
});

// about page
router.get('/about', (req, res, next) => {
    res.render('about', { title: 'about' });
});


module.exports = router;
