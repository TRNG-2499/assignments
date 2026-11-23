SELECT d.* FROM doctor d
	LEFT JOIN appointment a ON a.doctor_id = d.doctor_id
	WHERE a.doctor_id IS NULL;