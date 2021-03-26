CREATE TABLE IF NOT EXISTS `persistent_logins` (
  `username` varchar(64) NOT NULL,
  `series` varchar(64) NOT NULL,
  `token` varchar(64) NOT NULL,
  `last_used` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`series`)
);

INSERT INTO user(id, enabled, name, phone, password,role,username)
VALUES (1, 1, 'admin', '0123456789','$2a$12$cZpjQBhfxpEd3xBoywRTU.jx3f.UD/ygj/nR373ebd/0uZe.xtYZ2','ROLE_ADMIN','admin')
ON DUPLICATE KEY UPDATE id = 1;


