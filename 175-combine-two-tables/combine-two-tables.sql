select p.firstName,p.lastName,a.city,a.state
From Person p 
LEFT JOIN Address a 
on p.personId=a.personId