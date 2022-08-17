-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Aug 11, 2022 at 04:22 AM
-- Server version: 5.7.33
-- PHP Version: 7.4.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `doisoat_vv_te`
--

-- --------------------------------------------------------

--
-- Table structure for table `compare_data`
--

CREATE TABLE `compare_data` (
  `compare_id` int(11) NOT NULL,
  `compare_date` date NOT NULL,
  `sys1_id` int(11) DEFAULT NULL,
  `sys2_id` int(11) DEFAULT NULL,
  `sys1_code` varchar(30) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  `sys2_code` varchar(30) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  `data_type` varchar(20) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  `sys1_trans_id` int(11) DEFAULT NULL,
  `sys1_trans_time` timestamp NULL DEFAULT NULL,
  `sys1_amount` bigint(20) DEFAULT NULL,
  `sys1_trans_type` varchar(20) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  `sys1_trans_status` varchar(10) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  `sys1_partner_trans_id` int(11) DEFAULT NULL,
  `sys2_trans_id` int(11) DEFAULT NULL,
  `sys2_trans_time` timestamp NULL DEFAULT NULL,
  `sys2_amount` bigint(20) DEFAULT NULL,
  `sys2_trans_type` varchar(20) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  `sys2_trans_status` varchar(10) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  `sys2_partner_trans_id` int(11) DEFAULT NULL,
  `compare_status` varchar(20) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  `compare_status_by_routine` tinyint(4) DEFAULT NULL,
  `create_by` varchar(50) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `session_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci COMMENT='Lưu kết quả so sánh từng bản ghi';

-- --------------------------------------------------------

--
-- Table structure for table `compare_data_summary`
--

CREATE TABLE `compare_data_summary` (
  `compare_data_sum_id` int(11) NOT NULL,
  `compare_date` date NOT NULL,
  `sys1_id` int(11) DEFAULT NULL,
  `sys2_id` int(11) DEFAULT NULL,
  `sys1_code` varchar(30) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  `sys2_code` varchar(30) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  `sys1_records` int(11) NOT NULL,
  `sys2_records` int(11) NOT NULL,
  `sys1_equal_records` int(11) NOT NULL,
  `sys1_equal_amount` bigint(20) DEFAULT NULL,
  `diff_status_records` int(11) NOT NULL,
  `diff_amount_records` int(11) NOT NULL,
  `sys1_minus_sys2` int(11) NOT NULL,
  `sys2_minus_sys1` int(11) NOT NULL,
  `trans_date` date DEFAULT NULL,
  `create_by` varchar(20) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  `create_datetime` timestamp NULL DEFAULT NULL,
  `compare_status` varchar(10) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  `compare_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

-- --------------------------------------------------------

--
-- Table structure for table `import_data`
--

CREATE TABLE `import_data` (
  `import_id` int(11) NOT NULL,
  `import_code` varchar(50) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `import_type` varchar(5) COLLATE utf8mb4_vietnamese_ci NOT NULL DEFAULT 'f' COMMENT 'f: file, d: db link',
  `system_code` varchar(50) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `file_name` varchar(255) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  `total_amount` bigint(20) DEFAULT NULL,
  `number_of_total` int(11) DEFAULT NULL COMMENT 'tổng số bản ghi import',
  `number_of_success` int(11) DEFAULT NULL COMMENT 'tổng số bản ghi import thành công',
  `number_of_fail` int(11) DEFAULT NULL COMMENT 'tổng số bản ghi import thất bại',
  `import_date` timestamp NULL DEFAULT NULL COMMENT 'ngày import',
  `import_by` varchar(100) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL COMMENT 'người import',
  `description` varchar(255) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  `order_no` int(11) DEFAULT NULL,
  `period_date` varchar(10) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL COMMENT 'import dữ liệu của ngày nào định dạng dd/mm/yyyy',
  `action_code` varchar(50) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  `status` int(11) DEFAULT '1' COMMENT '1: file hoạt động, 0: file đã bị hủy',
  `partner_system_id` int(11) NOT NULL,
  `session_id` int(11) NOT NULL,
  `evidence_file` varchar(255) COLLATE utf8mb4_vietnamese_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

-- --------------------------------------------------------

--
-- Table structure for table `import_data_detail`
--

CREATE TABLE `import_data_detail` (
  `import_detail_id` bigint(20) NOT NULL,
  `import_code` varchar(50) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `ref_id` varchar(30) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL COMMENT 'Mã tham chiếu',
  `trans_type` varchar(1) COLLATE utf8mb4_vietnamese_ci NOT NULL COMMENT 'D: debit, C:credit',
  `amount` int(11) NOT NULL,
  `trans_name` varchar(255) COLLATE utf8mb4_vietnamese_ci NOT NULL COMMENT 'Loại giao dịch',
  `trans_status` varchar(15) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `trans_time` timestamp NOT NULL,
  `trans_id` varchar(20) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  `import_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

-- --------------------------------------------------------

--
-- Table structure for table `partner`
--

CREATE TABLE `partner` (
  `id` int(11) NOT NULL,
  `code` varchar(20) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `name` varchar(200) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `description` varchar(500) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '1: active, 0: inactive'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci COMMENT='Đối tác, bao gồm cả Atomi';

-- --------------------------------------------------------

--
-- Table structure for table `partner_account`
--

CREATE TABLE `partner_account` (
  `id` int(11) NOT NULL,
  `account_number` varchar(20) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `bank_name` varchar(20) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `description` varchar(500) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  `status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '1: active, 0: inactive',
  `partner_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci COMMENT='Tài khoản chuyên thu của đối tác. Thường chỉ dùng cho Atomi';

-- --------------------------------------------------------

--
-- Table structure for table `partner_system`
--

CREATE TABLE `partner_system` (
  `id` int(11) NOT NULL,
  `code` varchar(20) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `name` varchar(200) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `description` varchar(500) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '1: active, 0: inactive',
  `partner_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci COMMENT='Các hệ thống cần đối soát của đối tác';

-- --------------------------------------------------------

--
-- Table structure for table `session`
--

CREATE TABLE `session` (
  `id` int(11) NOT NULL,
  `period_date` varchar(10) COLLATE utf8mb4_vietnamese_ci NOT NULL COMMENT 'chu kỳ đối soát. Có thể theo ngày (2022-07-07), hoặc theo tháng (2022-07)',
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '0: inactive, 1: mới khởi tạo, 2: đang xử lý, 3: đã chốt số liệu, 4: đã huỷ',
  `system_id_1` int(11) NOT NULL,
  `system_id_2` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci COMMENT='Phiên đối soát. Phiên có thể theo ngày/tháng';

-- --------------------------------------------------------

--
-- Table structure for table `session_account_statement`
--

CREATE TABLE `session_account_statement` (
  `id` int(11) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `description` varchar(500) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  `status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '1: active, 0: inactive',
  `acc_branch` varchar(10) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  `acc_name` varchar(200) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  `account_no` varchar(20) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `customer_no` varchar(20) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  `full_name` varchar(200) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  `trn_date` timestamp NULL DEFAULT NULL,
  `value_date` timestamp NULL DEFAULT NULL,
  `check_time` timestamp NULL DEFAULT NULL,
  `trn_ref_no` varchar(30) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `narrative` varchar(200) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  `amount` bigint(20) NOT NULL,
  `drcr` varchar(1) COLLATE utf8mb4_vietnamese_ci NOT NULL DEFAULT 'C' COMMENT 'loại sao kê. D: Debit, C: Credit',
  `open_balance` bigint(20) NOT NULL,
  `close_balance` bigint(20) NOT NULL,
  `current_balance` bigint(20) NOT NULL,
  `session_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci COMMENT='Chi tiết sao kê của tài khoản trong kỳ đối soát';

-- --------------------------------------------------------

--
-- Table structure for table `session_detail`
--

CREATE TABLE `session_detail` (
  `id` int(11) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `description` varchar(500) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  `action` varchar(100) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  `start_at` timestamp NULL DEFAULT NULL,
  `finish_at` timestamp NULL DEFAULT NULL,
  `status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '1: active, 0: inactive',
  `session_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci COMMENT='Chi tiết các bước thực hiện đối soát trong phiên';

--
-- Indexes for dumped tables
--

--
-- Indexes for table `compare_data`
--
ALTER TABLE `compare_data`
  ADD PRIMARY KEY (`compare_id`),
  ADD KEY `compare_data_session` (`session_id`);

--
-- Indexes for table `compare_data_summary`
--
ALTER TABLE `compare_data_summary`
  ADD PRIMARY KEY (`compare_data_sum_id`),
  ADD KEY `compare_data_summary_compare_data` (`compare_id`);

--
-- Indexes for table `import_data`
--
ALTER TABLE `import_data`
  ADD PRIMARY KEY (`import_id`),
  ADD UNIQUE KEY `import_data_ak_1` (`import_code`),
  ADD KEY `import_data_partner_system` (`partner_system_id`),
  ADD KEY `import_data_session` (`session_id`);

--
-- Indexes for table `import_data_detail`
--
ALTER TABLE `import_data_detail`
  ADD PRIMARY KEY (`import_detail_id`),
  ADD KEY `import_data_detail_import_data` (`import_id`);

--
-- Indexes for table `partner`
--
ALTER TABLE `partner`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `partner_account`
--
ALTER TABLE `partner_account`
  ADD PRIMARY KEY (`id`),
  ADD KEY `partner_account_partner` (`partner_id`);

--
-- Indexes for table `partner_system`
--
ALTER TABLE `partner_system`
  ADD PRIMARY KEY (`id`),
  ADD KEY `partner_system_partner` (`partner_id`);

--
-- Indexes for table `session`
--
ALTER TABLE `session`
  ADD PRIMARY KEY (`id`),
  ADD KEY `session_partner_system1` (`system_id_1`),
  ADD KEY `session_partner_system2` (`system_id_2`);

--
-- Indexes for table `session_account_statement`
--
ALTER TABLE `session_account_statement`
  ADD PRIMARY KEY (`id`),
  ADD KEY `session_account_statement_session` (`session_id`);

--
-- Indexes for table `session_detail`
--
ALTER TABLE `session_detail`
  ADD PRIMARY KEY (`id`),
  ADD KEY `session_detail_session` (`session_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `compare_data`
--
ALTER TABLE `compare_data`
  MODIFY `compare_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `import_data`
--
ALTER TABLE `import_data`
  MODIFY `import_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `partner`
--
ALTER TABLE `partner`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `partner_account`
--
ALTER TABLE `partner_account`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `partner_system`
--
ALTER TABLE `partner_system`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `session`
--
ALTER TABLE `session`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `session_account_statement`
--
ALTER TABLE `session_account_statement`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `session_detail`
--
ALTER TABLE `session_detail`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `compare_data`
--
ALTER TABLE `compare_data`
  ADD CONSTRAINT `compare_data_session` FOREIGN KEY (`session_id`) REFERENCES `session` (`id`);

--
-- Constraints for table `compare_data_summary`
--
ALTER TABLE `compare_data_summary`
  ADD CONSTRAINT `compare_data_summary_compare_data` FOREIGN KEY (`compare_id`) REFERENCES `compare_data` (`compare_id`);

--
-- Constraints for table `import_data`
--
ALTER TABLE `import_data`
  ADD CONSTRAINT `import_data_partner_system` FOREIGN KEY (`partner_system_id`) REFERENCES `partner_system` (`id`),
  ADD CONSTRAINT `import_data_session` FOREIGN KEY (`session_id`) REFERENCES `session` (`id`);

--
-- Constraints for table `import_data_detail`
--
ALTER TABLE `import_data_detail`
  ADD CONSTRAINT `import_data_detail_import_data` FOREIGN KEY (`import_id`) REFERENCES `import_data` (`import_id`);

--
-- Constraints for table `partner_account`
--
ALTER TABLE `partner_account`
  ADD CONSTRAINT `partner_account_partner` FOREIGN KEY (`partner_id`) REFERENCES `partner` (`id`);

--
-- Constraints for table `partner_system`
--
ALTER TABLE `partner_system`
  ADD CONSTRAINT `partner_system_partner` FOREIGN KEY (`partner_id`) REFERENCES `partner` (`id`);

--
-- Constraints for table `session`
--
ALTER TABLE `session`
  ADD CONSTRAINT `session_partner_system1` FOREIGN KEY (`system_id_1`) REFERENCES `partner_system` (`id`),
  ADD CONSTRAINT `session_partner_system2` FOREIGN KEY (`system_id_2`) REFERENCES `partner_system` (`id`);

--
-- Constraints for table `session_account_statement`
--
ALTER TABLE `session_account_statement`
  ADD CONSTRAINT `session_account_statement_session` FOREIGN KEY (`session_id`) REFERENCES `session` (`id`);

--
-- Constraints for table `session_detail`
--
ALTER TABLE `session_detail`
  ADD CONSTRAINT `session_detail_session` FOREIGN KEY (`session_id`) REFERENCES `session` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
