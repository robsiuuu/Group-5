<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://cdn.tailwindcss.com"></script>
    <title>User Details</title>
    <link rel="stylesheet" type="text/css" href="/static/style.css">
</head>
<body class="bg-gray-100">

<!-- Begin Nav Bar -->
<nav class="bg-blue-950 border-b-4 border-black fixed top-0 w-full z-50">
    <div class="mx-auto max-w-7xl px-4 sm:px-6 lg:px-8">
        <div class="flex h-[7vw] items-center justify-between">
            <div class="flex items-center">
                <a href="/index">
                    <img class="h-32 w-32" src="/UniVents.png" alt="UniVents">
                </a>
                <div class="ml-10 flex items-baseline space-x-4">
                    <a href="/admin/dashboard" class="rounded-md px-3 py-2 text-sm font-medium text-white hover:bg-blue-900">Dashboard</a>
                    <a href="/admin/users/all" class="rounded-md px-3 py-2 text-sm font-medium text-white hover:bg-blue-900">Manage Users</a>
                    <a href="/admin/events/all" class="rounded-md px-3 py-2 text-sm font-medium text-white hover:bg-blue-900">Manage Events</a>
                </div>
            </div>
            <div class="ml-4 flex items-center space-x-4">
                <a href="/logout" class="rounded-md px-6 py-2 bg-gray-800 text-white hover:text-red">Log Out</a>
            </div>
        </div>
    </div>
</nav>
<!-- End Nav Bar -->

<div class="container mx-auto px-4 py-20 mt-16">
    <h1 class="text-2xl font-bold mb-6">${title}</h1>

    <div class="bg-white rounded-lg shadow overflow-hidden">
        <div class="bg-blue-600 px-6 py-4">
            <h5 class="text-xl font-semibold text-white">${user.username}</h5>
        </div>

        <div class="p-6 relative">
            <div class="absolute top-6 right-6">
                <a href="/admin/users/update/${userId?c}"
                   class="px-4 py-2 bg-blue-500 text-white rounded hover:bg-blue-600 transition duration-200">
                    Edit User
                </a>
            </div>

            <div class="space-y-4">
                <div>
                    <h5 class="text-lg font-medium text-gray-900">ID: ${user.userId?c}</h5>
                </div>
                <div class="border-t border-gray-200 pt-4">
                    <p class="text-gray-700"><span class="font-semibold">Status:</span> ${user.accountStatus}</p>
                </div>
                <div class="border-t border-gray-200 pt-4">
                    <p class="text-gray-700"><span class="font-semibold">Role:</span> ${user.role}</p>
                </div>
                <div class="border-t border-gray-200 pt-4">
                    <p class="text-gray-700"><span class="font-semibold">Username:</span> ${user.username}</p>
                </div>
                <div class="border-t border-gray-200 pt-4">
                    <p class="text-gray-700"><span class="font-semibold">Password:</span> ${user.password}</p>
                </div>
                <div class="border-t border-gray-200 pt-4">
                    <p class="text-gray-700"><span class="font-semibold">Email:</span> ${user.email}</p>
                </div>
            </div>

            <div class="mt-8 flex space-x-4">
                <a href="/admin/users/ban/${userId?c}"
                   class="px-4 py-2 bg-red-500 text-white rounded hover:bg-red-600 transition duration-200">
                    Ban User
                </a>
            </div>
        </div>
    </div>
</div>

</body>
</html>