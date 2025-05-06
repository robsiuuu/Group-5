<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://cdn.tailwindcss.com"></script>
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="/static/style.css">
</head>
<body class="bg-gray-100 min-h-screen flex items-center justify-center">

<nav class="bg-blue-950 border-b-4 border-black fixed top-0 w-full z-50">
    <div class="mx-auto max-w-7xl px-4 sm:px-6 lg:px-8">
        <div class="flex h-[7vw] items-center justify-between">
            <div class="flex items-center">
                <div>
                    <a href="/index">
                        <img class="h-32 w-32" src="/UniVents.png" alt="UniVents">
                    </a>
                </div>
                <div>
                    <div class="ml-10 flex items-baseline space-x-4 links">
                        <a href="/signup" class="rounded-md px-3 py-2 text-sm font-medium text-white hover:bg-blue-900 hover:text-white">View Events</a>
                        <a href="/signup" class="rounded-md px-3 py-2 text-sm font-medium text-white hover:bg-blue-900 hover:text-white">Manage Events</a>
                    </div>
                </div>
            </div>
            <div>
                <div class="ml-4 flex items-center space-x-4">
                    <a href="/userInfo">
                        <button type="button" class="relative rounded-md px-6 py-2 bg-gray-800 p-1 text-white hover:text-red">
                            Profile
                        </button>
                    </a>
                    <a href="/logout">
                        <button type="button" class="relative rounded-md px-6 py-2 bg-gray-800 p-1 text-white hover:text-red">
                            Log Out
                        </button>
                    </a>
                </div>
            </div>
        </div>
    </div>
</nav>
<div class="bg-white rounded-lg shadow-md p-8 w-96">
    <h2 class="text-2xl font-bold mb-6 text-center">Login as ${role?capitalize}</h2>
    <form action="/authenticate" method="post">
        <input type="hidden" name="role" value="${role}">

        <div class="mb-4">
            <label class="block text-gray-700 mb-2" for="username">Username</label>
            <input type="text" id="username" name="username" class="w-full px-3 py-2 border rounded-md" required>
        </div>

        <div class="mb-6">
            <label class="block text-gray-700 mb-2" for="password">Password</label>
            <input type="password" id="password" name="password" class="w-full px-3 py-2 border rounded-md" required>
        </div>

        <button type="submit" class="w-full bg-blue-500 text-white py-2 rounded-md hover:bg-blue-600 transition">
            Login
        </button>

        <#if error??>
        <p class="text-red-500 mt-2">${error}</p>
    </#if>
    </form>
    <a href="/choose-role" class="text-blue-500 hover:underline">← Back to Role Selection</a>
</div>



</body>
</html>