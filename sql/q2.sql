SELECT count(id) FROM member WHERE id NOT IN ( SELECT member_id FROM checkout_item );

/* Answer: 37 */
