SELECT first_name, last_name FROM Doctor d
WHERE NOT EXISTS (SELECT 1 FROM Appointment a WHERE a.doctor_id = d.doctor_id);