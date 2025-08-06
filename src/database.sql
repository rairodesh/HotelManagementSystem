
CREATE DATABASE hotel_db;
USE hotel_db;


-- Create reservations table
CREATE TABLE reservations (
    reservation_id INT AUTO_INCREMENT PRIMARY KEY,
    guest_name VARCHAR(255) NOT NULL,
    room_number INT NOT NULL,
    contact_number VARCHAR(10) NOT NULL,
    reservation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Insert sample data (optional)
INSERT INTO reservations (guest_name, room_number, contact_number)
VALUES
('Alice', 101, '9800000001'),
('Bob', 102, '9800000002');
