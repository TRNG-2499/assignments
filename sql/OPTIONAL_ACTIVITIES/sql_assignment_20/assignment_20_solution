-- CORE SOLUTION
SELECT s.student_id, 
  CASE 
    WHEN t.test_score < tc.pass_mark THEN NULL
    ELSE s.student_name
  END AS passing_student_name,
  t.test_score
FROM Student s
  JOIN TestEvent t ON s.student_id = t.student_id
  JOIN TestConfig tc ON t.test_id = tc.test_id
WHERE t.test_name = 'Introductory SQL'
ORDER BY t.test_score DESC;

-- STRETCH SOLUTION
SELECT s.student_id, 
  CASE 
    WHEN t.test_score < tc.pass_mark THEN NULL
    ELSE s.student_name
  END AS passing_student_name,
  tc.test_name,
  t.test_score
FROM Student s
  JOIN TestEvent t ON s.student_id = t.student_id
  JOIN TestConfig tc ON t.test_id = tc.test_id
ORDER BY tc.test_name ASC, t.test_score DESC;
