SELECT d.first_name, d.last_name
FROM Doctor d
LEFT JOIN Appointment a ON a.doctor_id = d.doctor_id
WHERE a.appointment_id IS NULL;

-- Stretch goal:
SELECT d.first_name, d.last_name
FROM Doctor d
WHERE NOT EXISTS (
    SELECT 1
    FROM Appointment a
    WHERE a.doctor_id = d.doctor_id AND a.status = 'Scheduled'
);