<!DOCTYPE html>
<html class="h-full bg-white" lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home Page</title>
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
                        <a href="/users/home" class="rounded-md px-3 py-2 underline text-sm font-medium text-white hover:bg-blue-900 hover:text-white">Dashboard</a>
                        <a href="/events/all" class="rounded-md px-3 py-2 text-sm font-medium text-white hover:bg-blue-900 hover:text-white">View Events</a>
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


    <main class="hero_section relative pb-0 border-b-4 border-black">
        <div class=" py-0 relative img_container">
            <div class="img_container relative">
                <!-- Background -->
                <img class="hero_img w-full h-auto object-cover brightness-50" src="/static/images/campevents.png" alt="UNCG Campus Events">

                <!-- Hero text -->
                <h1 class="absolute w-1/3 top-1/3 left-6 text-white text-4xl font-bold px-6 py-3 rounded-lg drop-shadow-[0_1.2px_1.2px_rgba(0,0,0,0.8)]">
                    Discover Campus Events Today
                </h1>
                <p class="absolute w-1/2 top-1/2 left-6 text-white text-lg px-6 py-3 rounded-lg drop-shadow-[0_1.2px_1.2px_rgba(0,0,0,0.8)]">
                    Find and create student events, club meetings, and campus activities all in one space.
                </p>

                <!-- Buttons -->
                <div class="m-auto absolute top-2/3 left-[40%] flex gap-4">
                    <a href="/events/all">
                        <button class="bg-blue-950 text-white px-6 py-3 rounded-lg hover:bg-blue-700 transition">
                            View Events
                        </button>
                    </a>
                    <a href="/events/myEvents">
                        <button class="bg-gray-800 text-white px-6 py-3 rounded-lg hover:bg-gray-600 transition">
                            Manage Events
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
                        <p class="mt-4 text-gray-500">Click on <a href="/events/all" class="rounded-md px-3 py-2 text-sm font-medium text-black hover:bg-blue-900 hover:text-white">View Events</a>
                            and Get Started Now!</p>
                </div>

                <div>
                    <h5 class="text-2xl font-bold tracking-tight text-black">Create and Post Events!</h5>
                        <p class="mt-4 text-gray-500">Create and Post Events To Get Attention From All UNCG Students!</p>
                        <p class="text-gray-500">Go to  <a href="/events/myEvents" class="rounded-md px-3 py-2 text-sm font-medium text-black hover:bg-blue-900 hover:text-white">Manage Events</a>
                            to Get Started Now!</p>

                </div>

                <div>
                    <h5 class="text-2xl font-bold tracking-tight text-black">Comment, Review, and Become Apart of The Community!</h5>
                </div>
            </div>
            <div class="grid grid-cols-1 grid-rows-1">
                <img src="/static/images/uncgmap.png" alt="UNCG map" class="rounded-lg bg-gray-100 border-4 border-gray-600" >
            </div>
        </div>
    </div>

    <!-- Third Part Home Page-->
    <div class="relative isolate overflow-hidden bg-white py-12 sm:py-32">
        <img src="/static/images/spiro.png" alt="" class="absolute left-1/2 top-0 -z-10 w-[80%] md:w-[50%] lg:w-[90%] object-cover object-center brightness-[40%] transform -translate-x-1/2 border-2 border-black rounded-lg">
        <div class="mx-auto max-w-7xl px-6 lg:px-8">
            <div class="mx-auto max-w-2xl lg:mx-0">
                <h2 class="text-5xl font-semibold tracking-tight text-white sm:text-7xl">Become Apart Of UNCG</h2>
                <p class="mt-8 text-lg font-medium text-pretty text-gray-300 sm:text-xl/8">Sign Up and find out about everyday events so that you are never out of the loop!</p>
            </div>
            <div class="mx-auto mt-10 max-w-2xl lg:mx-0 lg:max-w-none">
                <div class="grid grid-cols-1 gap-x-8 gap-y-6 text-base/7 font-semibold text-white sm:grid-cols-2 md:flex lg:gap-x-10">
                    <a href="events/all">View Events <span aria-hidden="true">&rarr;</span></a>
                    <a href="events/myEvents">Manage Events <span aria-hidden="true">&rarr;</span></a>
                    <a href="#">About Us <span aria-hidden="true">&rarr;</span></a>
                </div>
                <dl class="mt-16 grid grid-cols-1 gap-8 sm:mt-20 sm:grid-cols-2 lg:grid-cols-4">
                    <div class="flex flex-col-reverse gap-1">
                        <dt class="text-base/7 text-gray-300">Active Users</dt>
                        <dd class="text-4xl font-semibold tracking-tight text-white">50</dd>
                    </div>
                    <div class="flex flex-col-reverse gap-1">
                        <dt class="text-base/7 text-gray-300">Of Event Genres</dt>
                        <dd class="text-4xl font-semibold tracking-tight text-white">Wide Range</dd>
                    </div>
                    <div class="flex flex-col-reverse gap-1">
                        <dt class="text-base/7 text-gray-300">Updates on Events</dt>
                        <dd class="text-4xl font-semibold tracking-tight text-white">Immediate</dd>
                    </div>
                </dl>
            </div>
        </div>
    </div>



</div>
</body>
</html>
