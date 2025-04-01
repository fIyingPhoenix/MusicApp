from flask import Flask, request, abort, render_template
import threading
import webview

# Secret Token (Only Your App Knows This)
SECRET_TOKEN = "SecretKey123"

# Create Flask App
app = Flask(__name__)

@app.route("/")
def home():
    # Validate token from URL query
    token = request.args.get("token")
    if token != SECRET_TOKEN:
        abort(403)  # Forbidden

    return render_template("UI/index.html")  # Make sure the file exists!

# Function to Start Flask Server
def start_server():
    app.run(host="127.0.0.1", port=5000, debug=False, use_reloader=False)

# Run Flask in Background and Open a WebView Window
if __name__ == "__main__":
    server_thread = threading.Thread(target=start_server)
    server_thread.daemon = True
    server_thread.start()

    # Pass Secret Token in the URL
    webview.create_window(
        "My Desktop App",
       #
       #  "https://flying-phoenix.dev",
       f"http://127.0.0.1:5000/?token={SECRET_TOKEN}",  # Appends token to URL
        width=800,
        height=600
    )

    webview.start()
