import os 

from flask import Flask, render_template, request, make_response, send_from_directory 

app = Flask(__name__)


@app.route("/", methods=["GET"])
def index():
    return render_template("home.html")


@app.route("/lyntax/information", methods=["GET"])
def lyntax_info():
    return render_template("lyntax.html")


@app.route("/lyntax/download", methods=["GET"])
def lyntax_download_page():
    return render_template("download.html")

@app.route("/lyntax/download/<interface>", methods=["GET"])
def lyntax_download_zip(interface):
    if (interface == "cli"):
        return send_from_directory(os.getcwd() + "/static/lyntax/", filename="lyntax-cli.zip", as_attachment=True)
    elif (interface == "gui"):
        return send_from_directory(os.getcwd() + "/static/lyntax/", filename="lyntax-gui.zip", as_attachment=True)
    else:
        return render_template("download.html")


@app.route("/dsl")
def dsl():
    return render_template("dsl.html")


@app.route("/feedback", methods=["GET", "POST"])
def feedback():
    if (request.method == "POST"):
        print("POST Feedback")

    return render_template("feedback.html")


@app.route("/about")
def about():
    return render_template("about.html")


if __name__ == "__main__":
    app.run(debug=True, host="0.0.0.0", port=10401)
