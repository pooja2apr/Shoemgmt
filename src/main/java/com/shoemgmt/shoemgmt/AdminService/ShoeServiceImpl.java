package com.shoemgmt.shoemgmt.AdminService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoemgmt.shoemgmt.adminrepository.ShoeRepository;
import com.shoemgmt.shoemgmt.model.Shoe;

import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;
@Service
public class ShoeServiceImpl implements ShoeService {
	@Autowired
	ShoeRepository shoeRepository;


	@Override
	public List <Shoe> getAllShoe() {

		return shoeRepository.findAll();

	}

	@Override
	public void saveShoe(Shoe shoe) {
		this.shoeRepository.save(shoe);
	}
	 @Override
	    public Shoe getShoeBySid(long sid) {
	        Shoe shoe = shoeRepository.findById(sid).get();
	        return shoe;
	    }
	@Override
	public void deleteShoeBySid(long sid) {
		this.shoeRepository.deleteById(sid);
	}


}
