SELECT d.first_name, d.last_name
FROM doctor d
LEFT JOIN appointment a
ON d.doctor_id = a.doctor_id
WHERE a.doctor_id IS NULL