CREATE TABLE insurance_product (
    id INT PRIMARY KEY AUTO_INCREMENT,
    product_name VARCHAR(255) NOT NULL,
    term INT, -- 期限，以月或年为单位
    type VARCHAR(50), -- 保险类型，例如：人寿保险、健康保险等
    payment_method VARCHAR(50), -- 缴费方式，例如：月缴、年缴、一次性缴清
    price DECIMAL(10, 2), -- 价格，假设以某种货币单位表示
    description VARCHAR(1024), -- 产品描述
    start_date VARCHAR(50), -- 产品起售日期
    main_image_url VARCHAR(255), -- 产品主图
    user_id INT -- 被保人ID
);
CREATE TABLE user_entity (
  id INT PRIMARY KEY AUTO_INCREMENT,
  username VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL UNIQUE,
  password VARCHAR(255) NOT NULL,
  role VARCHAR(50) NOT NULL,
  status VARCHAR(50) NOT NULL,
  created_at VARCHAR(50) NOT NULL
);