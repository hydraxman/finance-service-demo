DROP TABLE IF EXISTS insurance_product;
CREATE TABLE insurance_product (
    id serial NOT NULL,
    product_name VARCHAR(255) NOT NULL,
    term INT, -- 期限，以月或年为单位
    type VARCHAR(50), -- 保险类型，例如：人寿保险、健康保险等
    payment_method VARCHAR(50), -- 缴费方式，例如：月缴、年缴、一次性缴清
    price DECIMAL(10, 2), -- 价格，假设以某种货币单位表示
    description VARCHAR(1024), -- 产品描述
    start_date VARCHAR(50), -- 产品起售日期
    main_image_url VARCHAR(255), -- 产品主图
    user_id INT, -- 被保人ID
    primary key (id)
);
DROP TABLE IF EXISTS user_entity;
CREATE TABLE user_entity (
  id serial NOT NULL,
  username VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL UNIQUE,
  password VARCHAR(255) NOT NULL,
  role VARCHAR(50) NOT NULL,
  status VARCHAR(50) NOT NULL,
  created_at VARCHAR(50) NOT NULL,
  primary key (id)
);

INSERT INTO insurance_product (product_name, term, type, payment_method, price, description, start_date, main_image_url, user_id)
VALUES
('全面健康保险', 12, '健康保险', '月缴', 99.99, '提供全面的健康保障，覆盖门诊和住院治疗。', '2024-01-01', 'http://example.com/images/product1.jpg', 1),
('家庭综合保险', 24, '综合保险', '年缴', 199.99, '为全家人提供综合保障，包括健康、旅行和住宅保险。', '2024-02-01', 'http://example.com/images/product2.jpg', 2),
('旅行安全保险', 6, '旅行保险', '趸缴', 59.99, '为您的旅行提供全方位保障，包括医疗紧急情况和行李丢失。', '2024-03-01', 'http://example.com/images/product3.jpg', 1),
('汽车保险', 12, '汽车保险', '月缴', 129.99, '全面覆盖汽车相关的风险，包括交通事故、盗窃和自然灾害。', '2024-04-01', 'http://example.com/images/product4.jpg', 2),
('人寿保险', 120, '人寿保险', '年缴', 499.99, '为您和家人提供长期的人寿保障。', '2024-05-01', 'http://example.com/images/product5.jpg', 2);

INSERT INTO user_entity (username, email, password, role, status, created_at) VALUES
('gentleman', 'user1@example.com', 'password1', 'admin', 'active', '2023-01-01T00:00:00Z'),
('lady', 'user2@example.com', 'password2', 'user', 'active', '2023-01-02T00:00:00Z');
