-- 商品データの追加
INSERT INTO products (content_id, title, description, price, release_date, reservation_start_date, reservation_end_date, active)
VALUES 
('PROD001', '商品1', '商品1の説明', 1000, '2024-04-01 10:00:00', '2024-03-01 00:00:00', '2024-03-31 23:59:59', true),
('PROD002', '商品2', '商品2の説明', 2000, '2024-04-15 10:00:00', '2024-03-15 00:00:00', '2024-04-14 23:59:59', true),
('PROD003', '商品3', '商品3の説明', 3000, '2024-05-01 10:00:00', '2024-04-01 00:00:00', '2024-04-30 23:59:59', false); 