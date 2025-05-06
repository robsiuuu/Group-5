<!DOCTYPE html>
<html class="h-full bg-gray-50" lang="en">
<head>
    <meta charset="UTF-8">
    <title>Sign Up</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <style>
        .input-field {
            @apply w-full px-4 py-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500;
        }
        .btn-primary {
            @apply w-full bg-blue-600 text-white py-2 px-4 rounded-md hover:bg-blue-700 transition duration-200;
        }
        .radio-option {
            @apply flex items-center ps-4 border border-gray-200 rounded;
        }
        .radio-option input[type="radio"] {
            @apply w-4 h-4 text-blue-600 focus:ring-blue-500;
        }
    </style>
</head>
<body class="h-full">

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

<!-- Main Content -->
<main class="pt-20 min-h-screen">
    <div class="flex min-h-full flex-col justify-center pt-24 pb-12 sm:px-6 lg:px-8">
        <div class="sm:mx-auto sm:w-full sm:max-w-md">
            <img class="mx-auto h-16 w-auto" src="/logo.png" alt="UniVents Logo">
            <h2 class="mt-6 text-center text-2xl font-bold tracking-tight text-gray-900">Create Your Account</h2>
        </div>

        <div class="mt-8 sm:mx-auto sm:w-full sm:max-w-md">
            <div class="bg-white py-8 px-4 shadow sm:rounded-lg sm:px-10">
                <!-- Sign Up Form -->
                <form class="space-y-6" action="/users/new" method="post">

                    <div>
                        <label class="block text-sm font-medium text-gray-700 mb-2">I am signing up as:</label>
                        <div class="grid gap-2">
                            <div class="radio-option">
                                <input id="customer-role" name="role" type="radio" value="CUSTOMER" class="w-4 h-4"
                                       required>
                                <label for="customer-role" class="w-full py-3 ms-2 text-sm font-medium text-gray-900">
                                    Customer (I want to attend events)
                                </label>
                            </div>
                            <div class="radio-option">
                                <input id="provider-role" name="role" type="radio" value="PROVIDER" class="w-4 h-4">
                                <label for="provider-role" class="w-full py-3 ms-2 text-sm font-medium text-gray-900">
                                    Provider (I want to host events)
                                </label>
                            </div>
                        </div>
                    </div>

                    <div>
                        <label for="username" class="block text-sm font-medium text-gray-700">Username</label>
                        <div class="mt-1">
                            <input id="username" name="username" type="username" autocomplete="username" required
                                   class="block w-full appearance-none rounded-md border border-gray-300 px-3 py-2 placeholder-gray-400 shadow-sm focus:border-blue-500 focus:outline-none focus:ring-blue-500 sm:text-sm">
                        </div>
                    </div>

                    <div>
                        <label for="email" class="block text-sm font-medium text-gray-700">Email address</label>
                        <div class="mt-1">
                            <input id="email" name="email" type="email" autocomplete="email" required
                                   class="block w-full appearance-none rounded-md border border-gray-300 px-3 py-2 placeholder-gray-400 shadow-sm focus:border-blue-500 focus:outline-none focus:ring-blue-500 sm:text-sm">
                        </div>
                    </div>

                    <div>
                        <label for="password" class="block text-sm font-medium text-gray-700">Password</label>
                        <div class="mt-1">
                            <input id="password" name="password" type="password" autocomplete="new-password" required
                                   class="block w-full appearance-none rounded-md border border-gray-300 px-3 py-2 placeholder-gray-400 shadow-sm focus:border-blue-500 focus:outline-none focus:ring-blue-500 sm:text-sm">
                        </div>
                    </div>

                    <div>
                        <label for="confirmPassword" class="block text-sm font-medium text-gray-700">Confirm
                            Password</label>
                        <div class="mt-1">
                            <input id="confirmPassword" name="confirmPassword" type="password"
                                   autocomplete="new-password" required
                                   class="block w-full appearance-none rounded-md border border-gray-300 px-3 py-2 placeholder-gray-400 shadow-sm focus:border-blue-500 focus:outline-none focus:ring-blue-500 sm:text-sm">
                        </div>
                    </div>

                    <div>
                        <button type="submit"
                                class="flex w-full justify-center rounded-md border border-transparent bg-blue-600 py-2 px-4 text-sm font-medium text-white shadow-sm hover:bg-blue-700 focus:outline-none focus:ring-2 focus:ring-blue-500 focus:ring-offset-2">
                            Sign Up
                        </button>
                    </div>
                </form>

                <!-- Sign In Link -->
                <div class="mt-6 text-center">
                    <p class="text-sm text-gray-600">
                        Already have an account?
                        <a href="/choose-role" class="font-medium text-blue-600 hover:text-blue-500">Sign in</a>
                    </p>
                </div>
            </div>
        </div>
    </div>
</main>

</body>
</html>