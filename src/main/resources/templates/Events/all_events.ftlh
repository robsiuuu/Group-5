<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://cdn.tailwindcss.com"></script>
    <title>Manage Events</title>
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


    <!-- Event Table -->
    <div class="overflow-x-auto bg-white rounded-lg shadow">
        <table class="min-w-full divide-y divide-gray-200">
            <thead class="bg-gray-50">
            <tr>
                <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">ID</th>
                <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Creator</th>
                <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Event Name</th>
                <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Location</th>
                <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Genre</th>
                <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Date</th>
                <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Actions</th>
            </tr>
            </thead>
            <tbody class="bg-white divide-y divide-gray-200">
            <#list eventsList as event>
            <tr>
                <td class="px-6 py-4 whitespace-nowrap">
                    <a href="/admin/events/${event.eventId?c}" class="text-blue-600 hover:text-blue-800 hover:underline">
                        ${event.eventId?c}
                    </a>
                </td>
                <td class="px-6 py-4 whitespace-nowrap">${event.creator}</td>
                <td class="px-6 py-4 whitespace-nowrap">${event.eventName}</td>
                <td class="px-6 py-4 whitespace-nowrap">${event.eventLocation!''}</td>
                <td class="px-6 py-4 whitespace-nowrap">${event.eventGenre!''}</td>
                <td class="px-6 py-4 whitespace-nowrap">${event.eventDate?string('yyyy-MM-dd')}</td>
                <td class="px-6 py-4 whitespace-nowrap">
                    <a href="/admin/events/ban/${event.eventId?c}"
                       class="px-4 py-2 bg-red-500 text-white rounded hover:bg-red-600">Ban</a>
                </td>
            </tr>
            </#list>
            </tbody>
        </table>
    </div>

</div>
</body>
</html>