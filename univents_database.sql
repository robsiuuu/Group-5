-- phpMyAdmin SQL Dump
-- version 5.2.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: May 06, 2025 at 07:07 PM
-- Server version: 8.0.39
-- PHP Version: 8.2.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `univents_database`
--

-- --------------------------------------------------------

--
-- Table structure for table `events`
--

CREATE TABLE `events` (
  `event_id` int NOT NULL,
  `event_date` datetime(6) NOT NULL,
  `event_description` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `event_location` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `event_name` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `event_time` datetime(6) NOT NULL,
  `creator_id` int NOT NULL,
  `latitude` double NOT NULL,
  `longitude` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `events`
--

INSERT INTO `events` (`event_id`, `event_date`, `event_description`, `event_location`, `event_name`, `event_time`, `creator_id`, `latitude`, `longitude`) VALUES
(1, '2025-05-06 00:00:00.000000', 'present our website', 'PETTY 007', 'PRESENTATION', '1970-01-01 15:30:00.000000', 5, 0, 0),
(6, '2025-05-06 00:00:00.000000', 'a', 'a', 'a', '1970-01-01 02:05:00.000000', 9, 0, 0),
(7, '2025-05-06 00:00:00.000000', 'e', 'UNCG Auditorium, Tate Street, Greensboro, NC, USA', 'e', '1970-01-01 02:48:00.000000', 9, 36.06686609999999, -79.8059744);

-- --------------------------------------------------------

--
-- Table structure for table `events_reviews`
--

CREATE TABLE `events_reviews` (
  `event_event_id` int NOT NULL,
  `reviews_review_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `events_statistics`
--

CREATE TABLE `events_statistics` (
  `event_event_id` int NOT NULL,
  `statistics_statistic_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `replies`
--

CREATE TABLE `replies` (
  `reply_id` int NOT NULL,
  `reply_content` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `reply_date` datetime(6) NOT NULL,
  `review_id` int NOT NULL,
  `provider_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `reviews`
--

CREATE TABLE `reviews` (
  `review_id` int NOT NULL,
  `rating` int NOT NULL,
  `review_content` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `review_date` datetime(6) NOT NULL,
  `event_id` int NOT NULL,
  `user_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `reviews`
--

INSERT INTO `reviews` (`review_id`, `rating`, `review_content`, `review_date`, `event_id`, `user_id`) VALUES
(1, 4, 'cool', '2025-05-06 14:53:46.000000', 7, 1);

-- --------------------------------------------------------

--
-- Table structure for table `statistics`
--

CREATE TABLE `statistics` (
  `statistic_id` int NOT NULL,
  `statistic_created_at` datetime(6) DEFAULT NULL,
  `statistic_data` int NOT NULL,
  `statistic_description` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `statistic_title` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `statistic_updated_at` datetime(6) DEFAULT NULL,
  `event_id` int NOT NULL,
  `user_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `subscriptions`
--

CREATE TABLE `subscriptions` (
  `id` int NOT NULL,
  `event_id` int NOT NULL,
  `user_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `user_id` int NOT NULL,
  `account_status` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `email` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `last_updated_at` datetime(6) NOT NULL,
  `password` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `role` enum('ADMIN','CUSTOMER','PROVIDER') COLLATE utf8mb4_general_ci DEFAULT NULL,
  `username` varchar(255) COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `account_status`, `email`, `last_updated_at`, `password`, `role`, `username`) VALUES
(1, 'ACTIVE', 'robsiu@admin.com', '2025-05-01 13:21:42.000000', 'admin123', 'ADMIN', 'rob'),
(2, 'ACTIVE', 'adrian@admin.com', '2025-05-01 13:24:34.000000', 'admin123', 'ADMIN', 'adrian'),
(3, 'ACTIVE', 'alex@admin.com', '2025-05-01 13:25:07.000000', 'admin123', 'ADMIN', 'alex'),
(4, 'ACTIVE', 'billyjeans34@hotmail.com', '2025-05-02 13:38:26.664000', 'mikejack123', 'CUSTOMER', 'billyjeans34'),
(5, 'ACTIVE', 'herobine@outlook.com', '2025-05-06 12:24:13.539000', 'ihatesteve123', 'PROVIDER', 'herobrine1'),
(6, 'ACTIVE', 'bubba@yahoo.com', '2025-05-02 18:46:03.417000', 'test123', 'CUSTOMER', 'bubba'),
(8, 'ACTIVE', 'cool123@gmail.com', '2025-05-06 14:30:39.123000', 'cool123', 'CUSTOMER', 'cool123'),
(9, 'ACTIVE', 'abc@gmail.com', '2025-05-06 13:31:42.387000', 'abc', 'PROVIDER', 'abc');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `events`
--
ALTER TABLE `events`
  ADD PRIMARY KEY (`event_id`),
  ADD KEY `FK7ljm71n1057envlomdxcni5hs` (`creator_id`);

--
-- Indexes for table `events_reviews`
--
ALTER TABLE `events_reviews`
  ADD UNIQUE KEY `UKik39kac7hsl1olvag1513ycgf` (`reviews_review_id`),
  ADD KEY `FK4rqf3vhdfvfvvg1skiuvmkxw` (`event_event_id`);

--
-- Indexes for table `events_statistics`
--
ALTER TABLE `events_statistics`
  ADD UNIQUE KEY `UK8e55i5i2bpwgj1788gespo9ka` (`statistics_statistic_id`),
  ADD KEY `FKg1vhmxbg2gsouj1bipc3dvm9u` (`event_event_id`);

--
-- Indexes for table `replies`
--
ALTER TABLE `replies`
  ADD PRIMARY KEY (`reply_id`),
  ADD KEY `FKbf77p21qvc3gf5won8fkfa7ms` (`review_id`),
  ADD KEY `FKk4epwpvuvxanhs9ke114doff7` (`provider_id`);

--
-- Indexes for table `reviews`
--
ALTER TABLE `reviews`
  ADD PRIMARY KEY (`review_id`),
  ADD KEY `FKem6jjo18jyueiqhferf3dwfbx` (`event_id`),
  ADD KEY `FKcgy7qjc1r99dp117y9en6lxye` (`user_id`);

--
-- Indexes for table `statistics`
--
ALTER TABLE `statistics`
  ADD PRIMARY KEY (`statistic_id`),
  ADD KEY `FKn03u85sleyxxuwfgam76g9n20` (`event_id`),
  ADD KEY `FKgubpcsln9g1fvbi3f5sgt5def` (`user_id`);

--
-- Indexes for table `subscriptions`
--
ALTER TABLE `subscriptions`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKjqje23xdnpgf4e91dxfu629o5` (`event_id`),
  ADD KEY `FKhro52ohfqfbay9774bev0qinr` (`user_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `events`
--
ALTER TABLE `events`
  MODIFY `event_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `replies`
--
ALTER TABLE `replies`
  MODIFY `reply_id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `reviews`
--
ALTER TABLE `reviews`
  MODIFY `review_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `statistics`
--
ALTER TABLE `statistics`
  MODIFY `statistic_id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `subscriptions`
--
ALTER TABLE `subscriptions`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `user_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `events`
--
ALTER TABLE `events`
  ADD CONSTRAINT `FK7ljm71n1057envlomdxcni5hs` FOREIGN KEY (`creator_id`) REFERENCES `users` (`user_id`);

--
-- Constraints for table `events_reviews`
--
ALTER TABLE `events_reviews`
  ADD CONSTRAINT `FK4rqf3vhdfvfvvg1skiuvmkxw` FOREIGN KEY (`event_event_id`) REFERENCES `events` (`event_id`),
  ADD CONSTRAINT `FKj2790tedo8oywcrpt8eb7t6jj` FOREIGN KEY (`reviews_review_id`) REFERENCES `reviews` (`review_id`);

--
-- Constraints for table `events_statistics`
--
ALTER TABLE `events_statistics`
  ADD CONSTRAINT `FKevc6koq91isc52f6c3vl317eb` FOREIGN KEY (`statistics_statistic_id`) REFERENCES `statistics` (`statistic_id`),
  ADD CONSTRAINT `FKg1vhmxbg2gsouj1bipc3dvm9u` FOREIGN KEY (`event_event_id`) REFERENCES `events` (`event_id`);

--
-- Constraints for table `replies`
--
ALTER TABLE `replies`
  ADD CONSTRAINT `FKbf77p21qvc3gf5won8fkfa7ms` FOREIGN KEY (`review_id`) REFERENCES `reviews` (`review_id`),
  ADD CONSTRAINT `FKk4epwpvuvxanhs9ke114doff7` FOREIGN KEY (`provider_id`) REFERENCES `users` (`user_id`);

--
-- Constraints for table `reviews`
--
ALTER TABLE `reviews`
  ADD CONSTRAINT `FKcgy7qjc1r99dp117y9en6lxye` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`),
  ADD CONSTRAINT `FKem6jjo18jyueiqhferf3dwfbx` FOREIGN KEY (`event_id`) REFERENCES `events` (`event_id`);

--
-- Constraints for table `statistics`
--
ALTER TABLE `statistics`
  ADD CONSTRAINT `FKgubpcsln9g1fvbi3f5sgt5def` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`),
  ADD CONSTRAINT `FKn03u85sleyxxuwfgam76g9n20` FOREIGN KEY (`event_id`) REFERENCES `events` (`event_id`);

--
-- Constraints for table `subscriptions`
--
ALTER TABLE `subscriptions`
  ADD CONSTRAINT `FKhro52ohfqfbay9774bev0qinr` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`),
  ADD CONSTRAINT `FKjqje23xdnpgf4e91dxfu629o5` FOREIGN KEY (`event_id`) REFERENCES `events` (`event_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
