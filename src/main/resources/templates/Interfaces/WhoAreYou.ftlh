<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://cdn.tailwindcss.com"></script>
    <title>Choose Your Role</title>
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

<!-- Role Selection Container -->
<div class="container mx-auto px-4 py-20 mt-16 text-center">
    <div class="bg-white rounded-lg shadow-md p-8 inline-block">
        <h2 class="text-2xl font-bold mb-6">Select Your Role</h2>
        <div class="space-y-4">
            <a href="/login?role=customer"
               class="block w-full px-6 py-3 bg-blue-500 text-white rounded-md hover:bg-blue-600 transition">
                Customer
            </a>
            <a href="/login?role=provider"
               class="block w-full px-6 py-3 bg-green-500 text-white rounded-md hover:bg-green-600 transition">
                Provider
            </a>
            <a href="/login?role=admin"
               class="block w-full px-6 py-3 bg-purple-500 text-white rounded-md hover:bg-purple-600 transition">
                Admin
            </a>
        </div>
    </div>
</div>

</body>
</html>