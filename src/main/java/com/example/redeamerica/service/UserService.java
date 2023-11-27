package com.example.redeamerica.service;

import com.example.redeamerica.dto.RedeamericaDTO;
import com.example.redeamerica.dto.UserDTO;
import com.example.redeamerica.model.MembershipRequestEntity;
import com.example.redeamerica.model.UserEntity;
import com.example.redeamerica.repository.MembershipRequestRepository;
import com.example.redeamerica.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    MembershipRequestRepository membershipRequestRepository;

    @Autowired
    PostService postService;

    public UserDTO getProfileInfoUser (){
        UserEntity userFound = postService.getByEmailAuthenticated();

        UserDTO userBuild = new UserDTO();
        userBuild.setId(userFound.getId());
        userBuild.setName(userFound.getName());
        userBuild.setLastName(userFound.getName());
        userBuild.setEmail(userFound.getEmail());
        userBuild.setPhone(userFound.getPhone());
        userBuild.setPassword(userFound.getPassword());
        userBuild.setCountry(userFound.getCountry());
        userBuild.setRoles(userFound.getRoles());
        return userBuild;
    }

    public RedeamericaDTO getProfileInfoRedeamerica (){
        UserEntity userFound = postService.getByEmailAuthenticated();

        RedeamericaDTO userBuild = new RedeamericaDTO();
        userBuild.setId(userFound.getId());
        userBuild.setName(userFound.getName());
        userBuild.setLastName(userFound.getName());
        userBuild.setEmail(userFound.getEmail());
        userBuild.setPhone(userFound.getPhone());
        userBuild.setPassword(userFound.getPassword());
        userBuild.setCountry(userFound.getCountry());
        userBuild.setRoles(userFound.getRoles());

        Long userId = userFound.getId();

        MembershipRequestEntity membershipRequest = membershipRequestRepository.findByUserId(userId).orElseThrow();

        userBuild.setTypeMembreship(membershipRequest.getTypeMembreship());
        userBuild.setAddress(membershipRequest.getAddress());
        userBuild.setIdentificationType(membershipRequest.getIdentificationType());
        userBuild.setIdentificationNumber(membershipRequest.getIdentificationNumber());
        userBuild.setUrlIdentificationScan(membershipRequest.getUrlIdentificationScan());
        userBuild.setEducationLevel(membershipRequest.getEducationLevel());
        userBuild.setUrlEducationCertificate(membershipRequest.getUrlEducationCertificate());
        return userBuild;
    }
}
