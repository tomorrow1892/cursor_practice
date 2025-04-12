-- 商品テーブルの作成
CREATE TABLE IF NOT EXISTS products (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    content_id VARCHAR(255) NOT NULL UNIQUE,
    title VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    price DECIMAL(19,2) NOT NULL,
    release_date TIMESTAMP NOT NULL,
    reservation_start_date TIMESTAMP NOT NULL,
    reservation_end_date TIMESTAMP NOT NULL,
    active BOOLEAN NOT NULL DEFAULT true
); 