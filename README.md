# Local-Multiclient-Server

A simple **multi-client chat application** built using Java Sockets.

## 🚀 Features

* Multiple clients can connect to a single server
* Real-time group messaging
* Uses TCP sockets
* Simple and easy to understand code

## 📁 Files in This Project

* **Server.java** – Starts the server and manages connected clients
* **Client.java** – Connects to the server and sends/receives messages
* **ClientHandler.java** – Handles each client in a separate thread

## ▶️ How to Run

### 1. Start the server

```
javac Server.java
java Server
```

### 2. Start one or more clients

```
javac Client.java
java Client
```

## 🧠 How It Works

* Server listens on a port (e.g., 1234)
* Each client that connects gets its own handler thread
* Messages from one client are broadcast to all others


## 📌 Summary

A basic but functional chat system perfect for learning **Java networking and multithreading**.
