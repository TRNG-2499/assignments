SELECT first_name, last_name
FROM Doctor d
WHERE NOT EXISTS(
	SELECT 1
	FROM Appointment a
	WHERE d.doctor_id = a.doctor_id
)

-- Stretch Goal

SELECT first_name, last_name
FROM Doctor d
WHERE NOT EXISTS(
	SELECT 1
	FROM Appointment a
	WHERE d.doctor_id = a.doctor_id AND a.status = 'Scheduled'
)
