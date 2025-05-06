<!DOCTYPE html>
<html class="h-full bg-white" lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home Page</title>
    <link rel="stylesheet" href="/static/style.css">
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="h-full">
<div class="min-h-full">

    <nav class="bg-blue-950 border-b-4 border-black fixed top-0 w-full z-50">
        <div class="mx-auto max-w-7xl px-4 sm:px-6 lg:px-8">
            <div class="flex h-[7vw] items-center justify-between">
                <div class="flex items-center">
                    <div>
                        <a href="/customer/dashboard">
                            <img class="h-32 w-32" src="/UniVents.png" alt="UniVents">
                        </a>
                    </div>
                    <div>
                        <div class="ml-10 flex items-baseline space-x-4 links">
                            <a href="/view-events" class="rounded-md px-3 py-2 text-sm font-medium text-white hover:bg-blue-900 hover:text-white">View Events</a>
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

    <main class="hero_section relative pb-0 border-b-4 border-black">
        <div class="py-0 relative img_container">
            <div class="img_container relative">
                <img class="hero_img w-full h-auto object-cover" src="/campevents.png" alt="UNCG Campus Events">

                <h1 class="absolute w-1/3 top-1/3 left-6 text-white text-4xl font-bold px-6 py-3 rounded-lg">
                    Discover Campus Events Today
                </h1>
                <p class="absolute w-1/2 top-1/2 left-6 text-white text-lg px-6 py-3 rounded-lg">
                    Find and create student events, club meetings, and campus activities all in one space.
                </p>

                <div class="mx-auto absolute top-2/3 left-10 flex gap-4">
                    <a href="/view-events">
                        <button class="bg-gray-800 text-white px-6 py-3 rounded-lg hover:bg-gray-600 transition">
                            View Events
                        </button>
                    </a>
                    <a href="">
                        <button class="bg-gray-800 text-white px-6 py-3 rounded-lg hover:bg-gray-600 transition">
                            Reviews
                        </button>
                    </a>
                </div>
            </div>
        </div>
    </main>

    <!-- Second Part Home Page -->
    <div class="bg-white">
        <div class="mx-auto grid max-w-2xl grid-cols-1 items-center gap-x-8 gap-y-16 px-4 py-24 sm:px-6 sm:py-32 lg:max-w-7xl lg:grid-cols-2 lg:px-8">
            <div class="flex flex-col justify-between gap-[8vw]">
                <div>
                    <h5 class="text-2xl font-bold tracking-tight text-black">View and Interact With Events All Around Campus!</h5>
                    <p class="mt-4 text-gray-500">
                        Click on <a href="/view-events" class="rounded-md px-3 py-2 text-sm font-medium text-black hover:bg-blue-900 hover:text-white">View Events</a> and Get Started Now!
                    </p>
                </div>

                <div>
                    <h5 class="text-2xl font-bold tracking-tight text-black">Create and Post Events!</h5>
                    <p class="mt-4 text-gray-500">Create and Post Events To Get Attention From All UNCG Students!</p>
                    <p class="text-gray-500">
                        Go to <a href="/manage-events" class="rounded-md px-3 py-2 text-sm font-medium text-black hover:bg-blue-900 hover:text-white">Manage Events</a> to Get Started Now!
                    </p>
                </div>

                <div>
                    <h5 class="text-2xl font-bold tracking-tight text-black">Comment, Review, and Become Apart of The Community!</h5>
                </div>
            </div>
            <div class="grid grid-cols-1 grid-rows-1">
                <img src="/campus-map.png" alt="UNCG map" class="rounded-lg bg-gray-100 border-4 border-gray-600">
            </div>
        </div>
    </div>

</div>

</body>
</html>
