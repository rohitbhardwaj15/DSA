(
    SELECT name AS results
    FROM Users
    WHERE user_id IN (
        SELECT user_id
        FROM MovieRating
        GROUP BY user_id
        HAVING COUNT(*) = (
            SELECT MAX(cnt)
            FROM (
                SELECT COUNT(*) AS cnt
                FROM MovieRating
                GROUP BY user_id
            ) t
        )
    )
    ORDER BY name ASC
    LIMIT 1
)

UNION ALL

(
    SELECT title AS results
    FROM Movies
    WHERE movie_id IN (
        SELECT movie_id
        FROM (
            SELECT movie_id, AVG(rating) AS avg_rating
            FROM MovieRating
            WHERE created_at >= '2020-02-01' 
              AND created_at < '2020-03-01'
            GROUP BY movie_id
        ) t
        WHERE avg_rating = (
            SELECT MAX(avg_rating)
            FROM (
                SELECT AVG(rating) AS avg_rating
                FROM MovieRating
                WHERE created_at >= '2020-02-01' 
                  AND created_at < '2020-03-01'
                GROUP BY movie_id
            ) x
        )
    )
    ORDER BY title ASC
    LIMIT 1
);
   
