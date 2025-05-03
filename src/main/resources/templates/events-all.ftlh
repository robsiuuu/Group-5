<!DOCTYPE html>
<html class="h-full bg-gray-100" lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View Events Page</title>
    <link rel="stylesheet" href="/static/css/events.css">
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="h-full">
<div class="min-h-full">
    <nav class="bg-blue-950 border-b-4 border-black fixed top-0 w-full z-50">
        <div class="mx-auto max-w-7xl px-4 sm:px-6 lg:px-8">
            <div class="flex h-[7vw] items-center justify-between">
                <!--Logo -->
                <div class="flex items-center space-x-6">
                    <img class="h-20 w-20" src="/static/images/UniVents.png" alt="UniVents">

                    <!-- Links -->
                    <div class="flex space-x-6">
                        <a href="/users/home" class="rounded-md px-3 py-2 text-sm font-medium text-white hover:bg-blue-900 hover:text-white">Dashboard</a>
                        <a href="/events/all" class="rounded-md underline px-3 py-2 text-sm font-medium text-white hover:bg-blue-900 hover:text-white">View Events</a>
                        <a href="/events/myEvents" class="rounded-md px-3 py-2 text-sm font-medium text-white">Manage Events</a>
                        <a href="#" class="rounded-md px-3 py-2 text-sm font-medium text-white hover:bg-blue-900 hover:text-white">About Us</a>
                    </div>
                </div>

                <div class="flex items-center space-x-6">

                    <!-- Profile dropdown -->
                    <div class="relative">
                        <button id="user-menu-button" class="flex items-center rounded-full bg-gray-800 text-sm focus:ring-2 focus:ring-white focus:ring-offset-2 focus:ring-offset-gray-800" onclick="toggleUserMenu()">
                            <img class="w-10 h-10 rounded-full" src="/static/images/profile.png" alt="User Profile">
                        </button>
                        <div id="user-menu" class="hidden absolute right-0 z-10 mt-2 w-48 origin-top-right rounded-md bg-white py-1 ring-1 shadow-lg ring-black/5">
                            <a href="/users/userInfo" class="block px-4 py-2 text-sm text-gray-700">Your Profile</a>
                            <a href="/users/loginForm" class="block px-4 py-2 text-sm text-gray-700">Sign out</a>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </nav>

    <script>
        function toggleUserMenu() {
            document.getElementById("user-menu").classList.toggle("hidden");
        }

        document.addEventListener("click", function(event) {
            const menu = document.getElementById("user-menu");
            const button = document.getElementById("user-menu-button");

            if (!menu.contains(event.target) && !button.contains(event.target)) {
                menu.classList.add("hidden");
            }
        });
    </script>

    <!-- Events -->
    <main class="pt-24">
        <!-- Create Events-->
        <div class="max-w-7xl mx-auto px-4 py-6 sm:px-6 lg:px-8">


            <div class="mt-[150px] text-center text-3xl">
                <h2>Events</h2>
            </div>

            <ul role="list" class="mt-6 divide-y divide-gray-200">
                <#list eventList as event>
                <li class="flex justify-between items-center gap-x-6 py-5">
                    <a class="block flex-1 min-w-0 p-0 rounded-lg hover:bg-gray-100" href="/events/${event.eventId}/click">
                        <div class="flex items-center gap-x-4">
                            <div class="min-w-0 flex-auto">
                                <p class="text-sm font-semibold text-gray-900 truncate">${event.eventName}</p>
                                <p class="mt-1 text-xs text-gray-500 truncate">
                                    ${event.eventDescription!''}
                                </p>
                            </div>
                        </div>
                    </a>
                    <div class="shrink-0 flex flex-col items-end sm:flex-row sm:items-center sm:gap-4">
                        <a href="/events/editForm?id=${event.eventId}">
                            <button class="px-4 py-2 bg-gray-800 text-white rounded-md hover:bg-gray-900">
                                Edit Event
                            </button>
                        </a>
                        <a href="/events/delete/${event.eventId}">
                            <button onclick="popupFn()" class="px-4 py-2 bg-red-600 text-white rounded-md hover:bg-red-900">
                                Delete
                            </button>
                        </a>
                        <p class="mt-1 sm:mt-0 text-xs text-gray-500">
                            Scheduled For     <time datetime="${event.eventDate}">
                            ${event.eventDate?string["MMM dd, yyyy"]}
                        </time>
                        </p>
                    </div>
                </li>
            </#list>
            </ul>

        </div>
    </main>
</div>
</body>
</html>
