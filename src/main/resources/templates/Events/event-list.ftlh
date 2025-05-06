<!DOCTYPE html>
<html class="h-full bg-gray-100" lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View Events Page</title>
    <link rel="stylesheet" href="/static/events.css">
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="h-full">
<div class="min-h-full">

    <nav class="bg-blue-950 border-b-4 border-black fixed top-0 w-full z-50">
        <div class="mx-auto max-w-7xl px-4 sm:px-6 lg:px-8">
            <div class="flex h-[7vw] items-center justify-between">
                <div class="flex items-center">
                    <div>
                        <a href="/provider/dashboard">
                            <img class="h-32 w-32" src="/UniVents.png" alt="UniVents">
                        </a>
                    </div>
                    <div>
                        <div class="ml-10 flex items-baseline space-x-4 links">
                            <a href="/view-events"
                               class="rounded-md px-3 py-2 text-sm font-medium text-white hover:bg-blue-900 hover:text-white">View
                                Events</a>
                            <a href="/provider/manage-events"
                               class="rounded-md px-3 py-2 text-sm font-medium text-white hover:bg-blue-900 hover:text-white">Manage
                                Events</a>
                        </div>
                    </div>
                </div>
                <div>
                    <div class="ml-4 flex items-center space-x-4">
                        <a href="/userInfo">
                            <button type="button"
                                    class="relative rounded-md px-6 py-2 bg-gray-800 p-1 text-white hover:text-red">
                                Profile
                            </button>
                        </a>
                        <a href="/logout">
                            <button type="button"
                                    class="relative rounded-md px-6 py-2 bg-gray-800 p-1 text-white hover:text-red">
                                Log Out
                            </button>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </nav>

    <!-- Events -->
    <main class="pt-24">
        <!-- Create Events-->
        <div class="max-w-7xl mx-auto px-4 py-6 sm:px-6 lg:px-8">
            <div class="max-w-2xl ml-auto mr-auto events_header">
                <img src="/campevents.png" alt="UNCG Events"
                     class="absolute left-1/2 top-[15vh] -z-10 md:w-[50%] lg:w-[35%] object-cover object-center brightness-[40%] transform -translate-x-1/2 border-2 border-black rounded-lg">
                <div class="relative flex flex-col items-center justify-center text-center mt-[90px]">
                    <h1 class="text-3xl font-bold text-white">Manage/Create New Events</h1>
                    <a href="/events/createForm">
                        <button class="mt-4 px-6 py-2 bg-gray-800 text-white rounded-md hover:bg-blue-900">
                            Create New Event
                        </button>
                    </a>
                </div>
            </div>


            <div class="mt-[150px] text-center text-3xl">
                <h2>Events</h2>
            </div>

            <ul role="list" class="mt-6 divide-y divide-gray-200">
                <#list eventList as event>
                <li class="flex justify-between items-center gap-x-6 py-5">
                    <a class="block flex-1 min-w-0 p-0 rounded-lg hover:bg-gray-100" href="/events/${event.eventId}">
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
                            <button onclick="popupFn()"
                                    class="px-4 py-2 bg-red-600 text-white rounded-md hover:bg-red-900">
                                Delete
                            </button>
                        </a>
                        <p class="mt-1 sm:mt-0 text-xs text-gray-500">
                            Scheduled For
                            <time datetime="${event.eventDate}">
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
