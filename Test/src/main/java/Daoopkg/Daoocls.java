package Daoopkg;

import java.io.IOException;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.multipart.MultipartFile;

import Beanpakg.Beanclls;

public class Daoocls {
	
	JdbcTemplate temp;

	public void setTemp(JdbcTemplate temp) {
		this.temp = temp;
	}

       
	
	//user registration
	
	public int userregister(Beanclls b) {
		
		String s="insert into userregister(firstname,lastname,phnno,email,username,password)values('"+b.getFirstname()+"',+'"+b.getLastname()+"',+'"+b.getPhnno()+"',+'"+b.getEmail()+"',+'"+b.getFirstname()+"',+'"+b.getPassword()+"')";
		return temp.update(s);
	}

	

	   //checking valid user for login
	
	public List<Beanclls> loginaction(Beanclls bean) {
		
String s="select * from userregister where username='"+bean.getUsername()+"' && password='"+bean.getPassword()+"'";
		
		return temp.query(s,new RowMapper<Beanclls>() {

			@Override
			public Beanclls mapRow(ResultSet r, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Beanclls b=new Beanclls();
				b.setId(r.getInt(1));
				b.setFirstname(r.getString(2));
				b.setLastname(r.getString(3));
				b.setPhnno(r.getInt(4));
				b.setEmail(r.getString(5));
				b.setPassword(r.getString(6));
				
				
				return b;
			}
			
			});		
	}
	
	      //code for admin add products
	
	public int productsadd(Beanclls b,MultipartFile image) throws IOException {
		byte[] photoBytes=image.getBytes();
		String s="insert into products(name,price,description,category,width,height,weight,quantity,shippingfee,image)values('"+b.getName()+"','"+b.getPrice()+"','"+b.getDescription()+"','"+b.getCategory()+"','"+b.getWidth()+"','"+b.getHeight()+"','"+b.getWeight()+"','"+b.getQuantity()+"','"+b.getShippingfee()+"',?)";
		return temp.update(s,new Object[] {photoBytes});
	
	}
	
	     
	//code for user view products

	public List<Beanclls>viewproduct()
	{
		String s="select * from products";
		return temp.query(s,new RowMapper<Beanclls>()
				{
			public Beanclls mapRow(ResultSet r,int row)throws SQLException
			{
				Beanclls b=new Beanclls();
				b.setPid(r.getInt(1));
				b.setName(r.getString(2));
				b.setPrice(r.getInt(3));
				b.setDescription(r.getString(4));
				return b;
			}
				}
				 
				);
	
	}
	
	public Blob getimage(int id) {//fetching image from data base
		String s="select image from products where pid=?";
		Blob img=temp.queryForObject(s,new Object[] { id},Blob.class);
		return img;
	}

	
	
	//more information about products
	public List<Beanclls>moreinfo(int pid)
	{
		String s="select pid,name,width,height,weight,price,quantity,shippingfee,image from products where pid='"+pid+"'";
		return temp.query(s,new RowMapper<Beanclls>()
				{
			public Beanclls mapRow(ResultSet r,int row)throws SQLException
			{
				Beanclls b=new Beanclls();
				b.setPid(r.getInt(1));
				b.setName(r.getString(2));
				b.setWidth(r.getInt(3));
				b.setHeight(r.getInt(4));
				b.setWeight(r.getInt(5));
				b.setPrice(r.getInt(6));
				b.setQuantity(r.getInt(7));
				b.setShippingfee(r.getInt(8));
				return b;
			}
				}
				 
				);
	
	}
	
	public Blob getimage1(int id) {//fetching image from database
		String s="select image from products where pid=?";
		Blob img=temp.queryForObject(s,new Object[] { id},Blob.class);
		return img;
	}

}
