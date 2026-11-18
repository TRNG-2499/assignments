SELECT d.first_name || ' ' || d.last_name AS doctor_name
FROM Doctor AS d
LEFT JOIN Appointment AS a ON d.doctor_id = a.doctor_id
WHERE a.appointment_id IS NULL;


SELECT d.first_name || ' ' || d.last_name AS doctor_name
FROM Doctor AS d
FULL OUTER JOIN Appointment AS a 
    ON d.doctor_id = a.doctor_id
    AND a.status = 'Scheduled'
WHERE a.status IS NULL;