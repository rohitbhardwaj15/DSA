SELECT user_id, name, mail
FROM Users
WHERE mail REGEXP '^[A-Za-z][A-Za-z0-9_.-]*@leetcode[.]com$'
  AND RIGHT(mail, 13) = BINARY '@leetcode.com';