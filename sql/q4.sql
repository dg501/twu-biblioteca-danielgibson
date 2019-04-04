INSERT INTO book (id, title) VALUES (11, 'The Pragmatic Programmer');
INSERT INTO member (id, name) VALUES (43, 'Daniel Gibson');
INSERT INTO checkout_item (member_id, book_id) VALUES (43, 11);
SELECT name FROM member WHERE id IN ( SELECT checkout_item.member_id FROM checkout_item, book WHERE checkout_item.book_id = book.id AND book.title = 'The Pragmatic Programmer' );

/* Answer: last query should return my name (Daniel Gibson) */
