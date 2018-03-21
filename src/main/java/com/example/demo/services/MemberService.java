package com.example.demo.services;

import com.example.demo.domain.Cpoi;
import com.example.demo.domain.Member;
import com.example.demo.error_handling.ResourceNotFoundException;
import com.example.demo.repositories.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService extends CrudService<Member, String, MemberRepository> {

    public MemberService(MemberRepository repository) {
        super(repository);
    }


    public List<Cpoi> getMemberFavoriteCpois(String id) {
        Optional<Member> entity = getRepository().findById(id);
        if (entity.isPresent()) {
            return entity.get().getId_cpois();
        }
        throw new ResourceNotFoundException("Member with this id does not exist");
    }

    public void favoriseCpoi(String id, String cpoi_id) {
        Optional<Member> entity = getRepository().findById(id);
        if (entity.isPresent()) {
            Cpoi cpoi = new Cpoi();
            cpoi.setId(cpoi_id);
            entity.get().getId_cpois().add(cpoi);
            getRepository().save(entity.get());
            return;
        }
        throw new ResourceNotFoundException("Member with this id does not exist");
    }
}
