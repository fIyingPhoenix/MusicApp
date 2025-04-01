from flask import Flask, request, abort, render_template, send_from_directory
import threading
import webview
import socket
import random
import os

# Secret Token (Only Your App Knows This)
SECRET_TOKEN = "SecretKey123"

# Create Flask App
app = Flask(__name__)
# Set static folder for CSS, JS, images
app.static_folder = 'static'

@app.route("/")
def home():
    return render_template("index.html")  # Make sure the file exists!

@app.route("/about")
def about():
    return render_template("about.html")  # Ensure about.html exists in the templates folder

@app.route("/<path:filename>")
def serve_file(filename):
    return send_from_directory(os.path.join(app.root_path, 'static'), filename)

# Check if the port is available
def is_port_available(port):
    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
        return s.connect_ex((socket.gethostname(), port)) != 0  # returns 0 if the port is in use

def generate_random_port():
    while True:
        port = random.randint(49152, 65535)  # Use ephemeral port range
        if is_port_available(port):
            return port

# Function to Start Flask Server
def start_server(port):
    app.run(host="127.0.0.1", port=port, debug=False, use_reloader=False)

# Run Flask in Background and Open a WebView Window
if __name__ == "__main__":
    port = generate_random_port()
    server_thread = threading.Thread(target=start_server, args=(port,))
    server_thread.daemon = True
    server_thread.start()

    # Pass Secret Token in the URL
    webview.create_window(
        "My Desktop App",
        f"http://127.0.0.1:{port}",  # Appends token to URL
        width=800,
        height=600
    )

    webview.start()
