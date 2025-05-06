<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://cdn.tailwindcss.com"></script>
    <title>Update User</title>
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
                <a href="/signup" class="rounded-md px-6 py-2 bg-gray-800 text-white hover:text-red">Profile</a>
            </div>
        </div>
    </div>
</nav>
<!-- End Nav Bar -->

<div class="container mx-auto px-4 py-20 mt-16">
    <h1 class="text-2xl font-bold mb-6">${title}</h1>

    <div class="bg-white rounded-lg shadow p-6">
        <form id="update-user" action="/admin/users/update/${user.userId?c}" method="post" class="space-y-4">
            <div>
                <label for="userId" class="block text-sm font-medium text-gray-700 mb-1">ID</label>
                <input type="text" id="userId" name="userId" value="${user.userId?c}" readonly
                       class="w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-blue-500 focus:border-blue-500 bg-gray-100">
            </div>

            <div>
                <label for="accountStatus" class="block text-sm font-medium text-gray-700 mb-1">Status</label>
                <input type="text" id="accountStatus" name="accountStatus" value="${user.accountStatus}" readonly
                       class="w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-blue-500 focus:border-blue-500 bg-gray-100">
            </div>

            <div>
                <label for="role" class="block text-sm font-medium text-gray-700 mb-1">Role</label>
                <input type="text" id="role" name="role" value="${user.role}" readonly
                       class="w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-blue-500 focus:border-blue-500 bg-gray-100">
            </div>

            <div>
                <label for="username" class="block text-sm font-medium text-gray-700 mb-1">Username</label>
                <input type="text" id="username" name="username" value="${user.username}" placeholder="Username"
                       class="w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-blue-500 focus:border-blue-500">
            </div>

            <div>
                <label for="password" class="block text-sm font-medium text-gray-700 mb-1">Password</label>
                <input type="text" id="password" name="password" value="${user.password}" placeholder="Password"
                       class="w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-blue-500 focus:border-blue-500">
            </div>

            <div>
                <label for="email" class="block text-sm font-medium text-gray-700 mb-1">Email</label>
                <input type="text" id="email" name="email" value="${user.email}" placeholder="Email"
                       class="w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-blue-500 focus:border-blue-500">
            </div>

            <div class="flex space-x-4 pt-4">
                <button type="submit"
                        class="px-4 py-2 bg-blue-600 text-white rounded-md hover:bg-blue-700 focus:outline-none focus:ring-2 focus:ring-blue-500 focus:ring-offset-2">
                    Save Changes
                </button>
                <a href="/admin/users/${user.userId?c}"
                   class="px-4 py-2 border border-gray-300 text-gray-700 rounded-md hover:bg-gray-50 focus:outline-none focus:ring-2 focus:ring-blue-500 focus:ring-offset-2">
                    Cancel
                </a>
            </div>
        </form>
    </div>
</div>
</body>
</html>