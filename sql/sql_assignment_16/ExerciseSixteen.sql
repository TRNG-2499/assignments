SELECT first_name, last_name FROM doctor
WHERE doctor_id NOT IN (SELECT doctor_id FROM appointment WHERE doctor_id IS NOT NULL);

SELECT first_name, last_name FROM doctor
WHERE doctor_id NOT IN (SELECT doctor_id FROM appointment WHERE status = 'Scheduled' AND doctor_id IS NOT NULL);