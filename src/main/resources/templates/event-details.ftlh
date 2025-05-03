<!DOCTYPE html>
<html class="h-full" lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Event Data</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="h-full bg-gray-50">
<nav class="bg-blue-950 border-b-4 border-black fixed top-0 w-full z-50">
    <div class="mx-auto max-w-7xl px-4 sm:px-6 lg:px-8">
        <div class="flex h-[7vw] items-center justify-between">
            <!--Logo -->
            <div class="flex items-center space-x-6">
                <img class="h-20 w-20" src="/static/images/UniVents.png" alt="UniVents">

                <!-- Links -->
                <div class="flex space-x-6">
                    <a href="/users/home" class="rounded-md px-3 py-2 text-sm font-medium text-white hover:bg-blue-900 hover:text-white">Dashboard</a>
                    <a href="/events/all" class="rounded-md px-3 py-2 text-sm font-medium text-white hover:bg-blue-900 hover:text-white">View Events</a>
                    <a href="/events/myEvents" class="rounded-md px-3  underline py-2 text-sm font-medium text-white">Manage Events</a>
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




<div class="container mx-auto px-6 py-12 mt-20">
    <!-- Event Information -->
    <div class="mb-6">
        <h3 class="text-lg font-semibold text-gray-900">Event Information</h3>
        <p class="text-sm text-gray-500">Specific Event Details.</p>
    </div>
    <div class="border-t border-gray-200 bg-white shadow-sm rounded-lg p-6">
        <dl class="divide-y divide-gray-100">
            <div class="grid sm:grid-cols-3 py-4">
                <dt class="text-sm font-medium text-gray-900">Event Title</dt>
                <dd class="text-sm text-gray-700 sm:col-span-2">${event.eventName}</dd>
            </div>
            <div class="grid sm:grid-cols-3 py-4">
                <dt class="text-sm font-medium text-gray-900">Location</dt>
                <dd class="text-sm text-gray-700 sm:col-span-2">${event.eventLocation}</dd>
            </div>
            <div class="grid sm:grid-cols-3 py-4">
                <dt class="text-sm font-medium text-gray-900">Event Date</dt>
                <dd class="text-sm text-gray-700 sm:col-span-2">${event.eventDate}</dd>
            </div>
            <div class="grid sm:grid-cols-3 py-4">
                <dt class="text-sm font-medium text-gray-900">Description</dt>
                <dd class="text-sm text-gray-700 sm:col-span-2">
                    ${(event.eventDescription)!"No description"}
                </dd>
            </div>
        </dl>
    </div>
</div>

<!-- Event Data -->
<div class="container mx-auto px-6 py-8">
    <div class="mb-6">
        <h3 class="text-lg font-semibold text-gray-900">Event Data</h3>
        <p class="text-sm text-gray-500">Specific Event Data.</p>
    </div>
    <div class="grid grid-cols-2 sm:grid-cols-2 gap-6">
        <#if statistic?has_content>
        <#list statistic as stat>
        <div class="bg-white shadow rounded-2xl p-6 border border-gray-100 hover:shadow-md transition">
            <h4 class="text-xl font-semibold text-gray-800 mb-2">${stat.statisticTitle}</h4>
            <p class="text-sm text-gray-600 mb-4">${stat.statisticDescription}</p>

            <div class="text-4xl font-bold text-indigo-600 mb-2">
                ${stat.statisticData}
            </div>

        </div>
        </#list>
        <#else>
        <p class="text-gray-500 italic">No statistics available for this event.</p>
        </#if>
        <!-- Reviews Column -->
        <div class="bg-white shadow rounded-2xl p-6 border border-gray-100 hover:shadow-md transition">
            <h3 class="text-md font-semibold text-gray-700 mb-4">Reviews</h3>
            <#if reviewList?has_content>
            <#list reviewList as review>
            <div class="bg-gray-50 p-5 rounded-xl shadow-sm mb-4 border">
                <p class="text-sm text-gray-800 mb-2">"${review.reviewContent}"</p>
                <p class="text-xs text-gray-500">— ${review.user.username}, Rating: ${review.rating}/5</p>
            </div>
        </#list>
        <#else>
        <p class="text-gray-500 italic">No reviews available for this event.</p>
        </#if>
        </div>




<!--        &lt;!&ndash; Statistic 2 &ndash;&gt;-->
<!--        <div class="bg-white shadow-sm rounded-lg p-6">-->
<!--            <h4 class="text-lg font-medium text-gray-900">Interaction Data</h4>-->
<!--            <p class="text-sm text-gray-600">Total Views, Shares.</p>-->
<!--            <img class="mt-4 w-full rounded-lg" src="/images/views.png" alt="">-->
<!--            <img src="" alt="">-->
<!--        </div>-->


<!--        &lt;!&ndash; Statistic 3 &ndash;&gt;-->
<!--        <div class="bg-white shadow-sm rounded-lg p-6 lg:col-span-2">-->
<!--            <h4 class="text-lg font-medium text-gray-900">Comments & Rating</h4>-->
<!--            <p class="text-sm text-gray-600">Total Comments, Average Event Rating.</p>-->
<!--            <div class="mx-auto flex max-w-xs flex-col gap-y-4 p-4 border-2 rounded-md text-center">-->
<!--                <dt class="text-base/7 text-gray-600">Comments</dt>-->
<!--                <a href="comments.html" class="hover:underline"><dt class="text-base/7 text-gray-600">View here</dt></a>-->
<!--                <dd class="order-first text-3xl font-semibold tracking-tight text-gray-900 sm:text-5xl">15</dd>-->
<!--            </div>-->
<!--            <div class="mx-auto flex items-center justify-center pt-24">-->
<!--                <svg class="w-4 h-4 text-yellow-300 me-1" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="currentColor" viewBox="0 0 22 20">-->
<!--                    <path d="M20.924 7.625a1.523 1.523 0 0 0-1.238-1.044l-5.051-.734-2.259-4.577a1.534 1.534 0 0 0-2.752 0L7.365 5.847l-5.051.734A1.535 1.535 0 0 0 1.463 9.2l3.656 3.563-.863 5.031a1.532 1.532 0 0 0 2.226 1.616L11 17.033l4.518 2.375a1.534 1.534 0 0 0 2.226-1.617l-.863-5.03L20.537 9.2a1.523 1.523 0 0 0 .387-1.575Z"/>-->
<!--                </svg>-->
<!--                <svg class="w-4 h-4 text-yellow-300 me-1" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="currentColor" viewBox="0 0 22 20">-->
<!--                    <path d="M20.924 7.625a1.523 1.523 0 0 0-1.238-1.044l-5.051-.734-2.259-4.577a1.534 1.534 0 0 0-2.752 0L7.365 5.847l-5.051.734A1.535 1.535 0 0 0 1.463 9.2l3.656 3.563-.863 5.031a1.532 1.532 0 0 0 2.226 1.616L11 17.033l4.518 2.375a1.534 1.534 0 0 0 2.226-1.617l-.863-5.03L20.537 9.2a1.523 1.523 0 0 0 .387-1.575Z"/>-->
<!--                </svg>-->
<!--                <svg class="w-4 h-4 text-yellow-300 me-1" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="currentColor" viewBox="0 0 22 20">-->
<!--                    <path d="M20.924 7.625a1.523 1.523 0 0 0-1.238-1.044l-5.051-.734-2.259-4.577a1.534 1.534 0 0 0-2.752 0L7.365 5.847l-5.051.734A1.535 1.535 0 0 0 1.463 9.2l3.656 3.563-.863 5.031a1.532 1.532 0 0 0 2.226 1.616L11 17.033l4.518 2.375a1.534 1.534 0 0 0 2.226-1.617l-.863-5.03L20.537 9.2a1.523 1.523 0 0 0 .387-1.575Z"/>-->
<!--                </svg>-->
<!--                <svg class="w-4 h-4 text-yellow-300 me-1" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="currentColor" viewBox="0 0 22 20">-->
<!--                    <path d="M20.924 7.625a1.523 1.523 0 0 0-1.238-1.044l-5.051-.734-2.259-4.577a1.534 1.534 0 0 0-2.752 0L7.365 5.847l-5.051.734A1.535 1.535 0 0 0 1.463 9.2l3.656 3.563-.863 5.031a1.532 1.532 0 0 0 2.226 1.616L11 17.033l4.518 2.375a1.534 1.534 0 0 0 2.226-1.617l-.863-5.03L20.537 9.2a1.523 1.523 0 0 0 .387-1.575Z"/>-->
<!--                </svg>-->
<!--                <svg class="w-4 h-4 text-gray-300 me-1 dark:text-gray-500" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="currentColor" viewBox="0 0 22 20">-->
<!--                    <path d="M20.924 7.625a1.523 1.523 0 0 0-1.238-1.044l-5.051-.734-2.259-4.577a1.534 1.534 0 0 0-2.752 0L7.365 5.847l-5.051.734A1.535 1.535 0 0 0 1.463 9.2l3.656 3.563-.863 5.031a1.532 1.532 0 0 0 2.226 1.616L11 17.033l4.518 2.375a1.534 1.534 0 0 0 2.226-1.617l-.863-5.03L20.537 9.2a1.523 1.523 0 0 0 .387-1.575Z"/>-->
<!--                </svg>-->
<!--                <p class="ms-1 text-sm font-medium text-gray-500 dark:text-gray-400">4.95</p>-->
<!--                <p class="ms-1 text-sm font-medium text-gray-500 dark:text-gray-400">out of</p>-->
<!--                <p class="ms-1 text-sm font-medium text-gray-500 dark:text-gray-400">5</p>-->
<!--            </div>-->
<!--            <p class="mx-auto flex text-base/7 text-gray-600 justify-center">12 reviews</p>-->
<!--        </div>-->
    </div>
</div>
</body>
</html>
