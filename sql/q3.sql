SELECT title FROM book WHERE id NOT IN ( SELECT book_id FROM checkout_item WHERE book_id IS NOT null ) UNION SELECT title FROM movie WHERE id NOT IN ( SELECT movie_id FROM checkout_item WHERE movie_id IS NOT null );

/* Answers:

1984
Catcher in the Rye
Crouching Tiger, Hidden Dragon
Domain Driven Design
Fellowship of the Ring
Lawrence of Arabia
Office Space
Thin Red Line
To Kill a Mockingbird
Tom Sawyer

*/
