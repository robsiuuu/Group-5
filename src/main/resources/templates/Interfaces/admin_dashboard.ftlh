<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://cdn.tailwindcss.com"></script>
    <title>Admin Dashboard</title>
</head>
<body class="bg-gray-100 min-h-screen flex items-center justify-center">

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


<div class="text-center">

    <div class="text-center mb-12">
        <h1 class="text-4xl font-bold text-gray-800">Welcome, Admin</h1>
        <h2 class="text-3xl text-gray-600 mt-2">Admin Dashboard</h2>
    </div>

    <div class="flex flex-col space-y-4 md:flex-row md:space-y-0 md:space-x-4 justify-center">

        <!-- Manage Users Button -->
        <a href="/admin/users/all"
           class="px-8 py-4 bg-blue-600 text-white rounded-lg shadow-md hover:bg-blue-700 transition duration-300 text-xl font-semibold">
            <div class="flex items-center justify-center">
                <svg xmlns="http://www.w3.org/2000/svg" class="h-8 w-8 mr-2" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                    <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M12 4.354a4 4 0 110 5.292M15 21H3v-1a6 6 0 0112 0v1zm0 0h6v-1a6 6 0 00-9-5.197M13 7a4 4 0 11-8 0 4 4 0 018 0z" />
                </svg>
                Manage Users
            </div>
        </a>

        <!-- Manage Events Button -->
        <a href="/admin/events/all"
           class="px-8 py-4 bg-green-600 text-white rounded-lg shadow-md hover:bg-green-700 transition duration-300 text-xl font-semibold">
            <div class="flex items-center justify-center">
                <svg xmlns="http://www.w3.org/2000/svg" class="h-8 w-8 mr-2" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                    <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M8 7V3m8 4V3m-9 8h10M5 21h14a2 2 0 002-2V7a2 2 0 00-2-2H5a2 2 0 00-2 2v12a2 2 0 002 2z" />
                </svg>
                Manage Events
            </div>
        </a>
    </div>
</div>

</body>
</html>