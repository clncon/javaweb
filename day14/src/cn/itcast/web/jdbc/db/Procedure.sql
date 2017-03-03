drop procedure add_pro;
delimiter //

create procedure add_pro(a int,b int,out sum int)
begin
 set sum = a+b;
end;
//

delimiter ;