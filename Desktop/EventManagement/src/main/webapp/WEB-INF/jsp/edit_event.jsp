<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <title>Edit Event</title>
        <!-- Google Fonts -->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600&display=swap" rel="stylesheet">
        <style>
            body {
                font-family: 'Inter', sans-serif;
                background-color: #f3f4f6;
                margin: 0;
                padding: 40px;
                display: flex;
                justify-content: center;
                align-items: center;
                min-height: 80vh;
            }

            .container {
                background-color: #ffffff;
                border-radius: 12px;
                box-shadow: 0 4px 6px -1px rgba(0, 0, 0, 0.1);
                padding: 40px;
                width: 100%;
                max-width: 500px;
            }

            h1 {
                color: #111827;
                text-align: center;
                margin-top: 0;
                margin-bottom: 30px;
                font-size: 1.5rem;
            }

            form {
                display: flex;
                flex-direction: column;
            }

            label {
                margin-bottom: 8px;
                color: #374151;
                font-weight: 500;
            }

            input[type="text"],
            input[type="date"] {
                padding: 12px;
                border: 1px solid #d1d5db;
                border-radius: 8px;
                margin-bottom: 20px;
                font-family: inherit;
                font-size: 1rem;
            }

            input[type="text"]:focus,
            input[type="date"]:focus {
                outline: none;
                border-color: #3b82f6;
                box-shadow: 0 0 0 2px #93c5fd;
            }

            input[type="submit"] {
                background-color: #2563eb;
                color: white;
                border: none;
                padding: 12px;
                border-radius: 8px;
                font-weight: 600;
                font-size: 1rem;
                cursor: pointer;
                transition: background-color 0.2s;
                margin-top: 10px;
            }

            input[type="submit"]:hover {
                background-color: #1d4ed8;
            }

            .back-link {
                display: block;
                text-align: center;
                margin-top: 20px;
                color: #6b7280;
                text-decoration: none;
            }

            .back-link:hover {
                color: #111827;
            }
        </style>
    </head>

    <body>

        <div class="container">
            <h1>Edit Event</h1>

            <form action="/events/update/${event.id}" method="post">
                <label for="name">Event Name</label>
                <input type="text" id="name" name="name" value="${event.name}" required>

                <label for="date">Event Date</label>
                <input type="date" id="date" name="date" value="${event.date}" required>

                <input type="submit" value="Update Event">
            </form>

            <a href="/events" class="back-link">← Back to List</a>
        </div>

    </body>

    </html>