SELECT d.first_name, d.last_name FROM doctor AS d
LEFT JOIN appointment AS a ON d.doctor_id = a.doctor_id
WHERE a.appointment_id IS NULL;

SELECT d.first_name, d.last_name FROM doctor AS d
LEFT JOIN appointment AS a ON d.doctor_id = a.doctor_id AND NOT a.status = 'Completed'
WHERE a.appointment_id IS NULL;