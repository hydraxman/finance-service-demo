CREATE TABLE insurance_product (
    id INT PRIMARY KEY AUTO_INCREMENT,
    product_name VARCHAR(255) NOT NULL,
    term INT, -- 期限，以月或年为单位
    type VARCHAR(50), -- 保险类型，例如：人寿保险、健康保险等
    payment_method VARCHAR(50), -- 缴费方式，例如：月缴、年缴、一次性缴清
    price DECIMAL(10, 2), -- 价格，假设以某种货币单位表示
    description VARCHAR(1024), -- 产品描述
    start_date DATE, -- 产品起售日期
    main_image_url VARCHAR(255), -- 产品主图
    clause_id INT, -- 保险条款ID
    end_date DATE -- 产品停售日期，NULL表示仍在售
);
