-- Sample DOCTOR users (email is unique, so re-running on redeploy won't duplicate)
INSERT IGNORE INTO users (id, name, email, password, phone, role, created_at) VALUES
(1, 'Dr. Anjali Sharma', 'anjali.sharma@hospital.com', 'doctor123', '9876500001', 'DOCTOR', NOW()),
(2, 'Dr. Rohan Mehta', 'rohan.mehta@hospital.com', 'doctor123', '9876500002', 'DOCTOR', NOW()),
(3, 'Dr. Priya Nair', 'priya.nair@hospital.com', 'doctor123', '9876500003', 'DOCTOR', NOW()),
(4, 'Dr. Vikram Singh', 'vikram.singh@hospital.com', 'doctor123', '9876500004', 'DOCTOR', NOW()),
(5, 'Dr. Sneha Kulkarni', 'sneha.kulkarni@hospital.com', 'doctor123', '9876500005', 'DOCTOR', NOW()),
(6, 'Dr. Arjun Verma', 'arjun.verma@hospital.com', 'doctor123', '9876500006', 'DOCTOR', NOW()),
(7, 'Dr. Kavita Reddy', 'kavita.reddy@hospital.com', 'doctor123', '9876500007', 'DOCTOR', NOW()),
(8, 'Dr. Manish Gupta', 'manish.gupta@hospital.com', 'doctor123', '9876500008', 'DOCTOR', NOW()),
(9, 'Dr. Neha Kapoor', 'neha.kapoor@hospital.com', 'doctor123', '9876500009', 'DOCTOR', NOW()),
(10, 'Dr. Suresh Iyer', 'suresh.iyer@hospital.com', 'doctor123', '9876500010', 'DOCTOR', NOW()),
(11, 'Dr. Pooja Desai', 'pooja.desai@hospital.com', 'doctor123', '9876500011', 'DOCTOR', NOW()),
(12, 'Dr. Karan Malhotra', 'karan.malhotra@hospital.com', 'doctor123', '9876500012', 'DOCTOR', NOW()),
(13, 'Dr. Ritu Bhatia', 'ritu.bhatia@hospital.com', 'doctor123', '9876500013', 'DOCTOR', NOW()),
(14, 'Dr. Amitabh Joshi', 'amitabh.joshi@hospital.com', 'doctor123', '9876500014', 'DOCTOR', NOW()),
(15, 'Dr. Shalini Rao', 'shalini.rao@hospital.com', 'doctor123', '9876500015', 'DOCTOR', NOW());

-- Doctor profiles linked to the users above (id is PK, safe to re-run with INSERT IGNORE)
-- photo_url uses free randomuser.me placeholder portraits (no upload needed)
INSERT IGNORE INTO doctors (id, user_id, specialization, experience_years, room_number, photo_url) VALUES
(1, 1, 'Cardiologist', 8, '101', 'https://randomuser.me/api/portraits/women/68.jpg'),
(2, 2, 'Orthopedic', 6, '102', 'https://randomuser.me/api/portraits/men/32.jpg'),
(3, 3, 'Dermatologist', 5, '103', 'https://randomuser.me/api/portraits/women/45.jpg'),
(4, 4, 'Neurologist', 10, '104', 'https://randomuser.me/api/portraits/men/54.jpg'),
(5, 5, 'Pediatrician', 7, '105', 'https://randomuser.me/api/portraits/women/21.jpg'),
(6, 6, 'General Physician', 9, '106', 'https://randomuser.me/api/portraits/men/76.jpg'),
(7, 7, 'Gynecologist', 11, '107', 'https://randomuser.me/api/portraits/women/33.jpg'),
(8, 8, 'ENT Specialist', 4, '108', 'https://randomuser.me/api/portraits/men/12.jpg'),
(9, 9, 'Psychiatrist', 6, '109', 'https://randomuser.me/api/portraits/women/56.jpg'),
(10, 10, 'Ophthalmologist', 12, '110', 'https://randomuser.me/api/portraits/men/41.jpg'),
(11, 11, 'Dentist', 5, '111', 'https://randomuser.me/api/portraits/women/12.jpg'),
(12, 12, 'Urologist', 8, '112', 'https://randomuser.me/api/portraits/men/65.jpg'),
(13, 13, 'Endocrinologist', 7, '113', 'https://randomuser.me/api/portraits/women/29.jpg'),
(14, 14, 'Gastroenterologist', 13, '114', 'https://randomuser.me/api/portraits/men/83.jpg'),
(15, 15, 'Pulmonologist', 6, '115', 'https://randomuser.me/api/portraits/women/72.jpg');