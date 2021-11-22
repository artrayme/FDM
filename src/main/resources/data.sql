INSERT INTO public.factory (id, name)
VALUES (1, 'TestFactory');
INSERT INTO public.factory (id, name)
VALUES (2, 'MTZ');

INSERT INTO public.warehouse (id, name, telephone, factory_id)
VALUES (1, 'Main Warehouse', '+375291389234', 1);
INSERT INTO public.warehouse (id, name, telephone, factory_id)
VALUES (2, 'Instruments', '+37529101204987', 2);
INSERT INTO public.warehouse (id, name, telephone, factory_id)
VALUES (3, 'Details', '+375291012073478', 2);

INSERT INTO public.input_report (id, date, worker_fio, worker_post, warehouse_id)
VALUES (1, '2021-11-21', 'Иванов Иван Иванович', 'Начальник склада', 3);
INSERT INTO public.input_report (id, date, worker_fio, worker_post, warehouse_id)
VALUES (2, '2021-11-21', 'Олегов Олег Олегович', 'Прохожий', 3);
INSERT INTO public.input_report (id, date, worker_fio, worker_post, warehouse_id)
VALUES (3, '2021-11-21', 'Петров Пётр Петрович', 'Заместитель начальника склада', 2);

INSERT INTO public.output_report (id, date, worker_fio, worker_post, warehouse_id)
VALUES (1, '2021-11-21', 'Ворюга', 'Директор', 3);

INSERT INTO public.inventory_unit (id, count, type, input_report_id, output_report_id)
VALUES (4, 324, 'Metal', 1, null);
INSERT INTO public.inventory_unit (id, count, type, input_report_id, output_report_id)
VALUES (5, 40, 'Engine', 1, null);
INSERT INTO public.inventory_unit (id, count, type, input_report_id, output_report_id)
VALUES (6, 5, 'Engine', 2, null);
INSERT INTO public.inventory_unit (id, count, type, input_report_id, output_report_id)
VALUES (7, 6, 'Engine', null, 1);


