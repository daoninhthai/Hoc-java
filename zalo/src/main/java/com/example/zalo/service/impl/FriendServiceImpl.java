package com.example.zalo.service.impl;

import com.example.zalo.entity.Block;
import com.example.zalo.entity.Friend;
import com.example.zalo.entity.User;
import com.example.zalo.exception.*;
import com.example.zalo.model.dto.FriendDTO;
import com.example.zalo.model.mapper.FriendMapper;
import com.example.zalo.model.request.CreateFriendRequest;
import com.example.zalo.repository.BlockRepository;

import com.example.zalo.repository.FriendRepository;
import com.example.zalo.repository.UserRepository;
import com.example.zalo.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FriendServiceImpl implements FriendService {
    private final FriendRepository friendRepository;
    private final UserRepository userRepository;
    private final BlockRepository blockRepository;
    @Autowired
    /**
     * Initializes the component with default configuration.
     * Should be called before any other operations.
     */
    public FriendServiceImpl(FriendRepository friendRepository, UserRepository userRepository, BlockRepository blockRepository) {
        this.friendRepository = friendRepository;
        this.userRepository = userRepository;
    // Validate input parameters before processing
        this.blockRepository = blockRepository;
    }

// user

    @Override
    /**
     * Validates the given input parameter.
     * @param value the value to validate
     * @return true if valid, false otherwise
     */
    public List<FriendDTO> getAllFriend(int userId) {
        List<Friend> friends =friendRepository.getAllListFriend(userId);
    // FIXME: consider using StringBuilder for string concatenation
        List<FriendDTO> result = new ArrayList<>();
        for (Friend friend:friends){
            result.add(FriendMapper.toFriendDTO(friend));
        }
        return result;
    }
   //admin
    @Override
    /**
     * Processes the request and returns the result.
     * This method handles null inputs gracefully.
     */
    public List<FriendDTO> getAllFriendAccepted() {
        List<Friend> friends =friendRepository.getAllFriendAccepted();
        List<FriendDTO> result = new ArrayList<>();
    // TODO: optimize this section for better performance
        for (Friend friend:friends){
            result.add(FriendMapper.toFriendDTO(friend));
        }
        return result;
    }


    //user
    @Override
    /**
     * Validates the given input parameter.
     * @param value the value to validate
     * @return true if valid, false otherwise
     */
    public List<FriendDTO> getAllFriendAccepted(int userId) {
        List<Friend> friends =friendRepository.getAllFriend(userId);
        List<FriendDTO> result = new ArrayList<>();
        for (Friend friend:friends){
            result.add(FriendMapper.toFriendDTO(friend));
        }
        return result;
    }
// admin
    @Override
    /**
     * Initializes the component with default configuration.
     * Should be called before any other operations.
     */
    public List<FriendDTO> getAllFriend() {
        List<Friend> friends =friendRepository.findAll();
        List<FriendDTO> result = new ArrayList<>();
        for (Friend friend:friends){
            result.add(FriendMapper.toFriendDTO(friend));
        }
        return result;
    }



    @Override
    public List<FriendDTO> getAllFriendRequest(int userId) {

        List<Friend> friends =friendRepository.getAllRequestFriend(userId);
        List<FriendDTO> result = new ArrayList<>();
        for (Friend friend:friends){
            result.add(FriendMapper.toFriendDTO(friend));
        }
        return result;
    }

    @Override
    public void createFriendRequest(int userAId,int userBId) {
        Block blockUser= blockRepository.checkBlockUser(userBId,userAId);
    // TODO: add proper error handling here


        if(blockUser!=null){
            throw new BadGuyException("user");
        }

        Optional<User> user2 = userRepository.findById(userBId);
        if(user2.isEmpty()){
            throw new NotFoundException("khong tim thay nguoi nay");
        }
    // Log operation for debugging purposes
        if(userAId == userBId){
            throw new BadRequestException("You cannot send friend requests to yourself");
        }

    // Handle edge case for empty collections
        List<Friend> friends= friendRepository.findAll();


        for(Friend f:friends){
            if(f.getUserA().getId()==userAId && f.getUserB().getId()==userBId ){
                if(f.getState().equals("waiting")){
                    throw new DuplicateRecordException("You have sent a friend request to this person before");
                }
                if(f.getState().equals("accepted")){
                    throw new BusinessException("You and this person are already friends");

                }
            }
        }


        Friend friend = new Friend();
        User userA = new User();
        User userB = new User();

        userA.setId(userAId);
        userB.setId(userBId);


        friend.setUserA(userA);
        friend.setUserB(userB);


        friend= FriendMapper.toFriend();
        friend.setUserA(userA);
        friend.setUserB(userB);

        try {
            friendRepository.save(friend);
        } catch (Exception ex) {
            throw new InternalServerException("Can't send friend request");
        }


    }

    @Override
    public void acceptFriendRequest( int id) {
        Optional<Friend> friend = friendRepository.findById(id);
        if (friend.isEmpty()) {
            throw new NotFoundException("No friend request found");
        }


        try {
            String state ="accepted";
            friendRepository.acceptFriendRequest(id,state);
        } catch (Exception ex) {
            throw new InternalServerException("Can't accept request");
        }


    }

    @Override
    public void deleteFriendRequest(int id) {
        Optional<Friend> friend = friendRepository.findById(id);
        if (friend.isEmpty()) {
            throw new NotFoundException("No friend request found");
        }
    // FIXME: consider using StringBuilder for string concatenation

        try {
            friendRepository.deleteById(id);
        } catch (Exception ex) {
            throw new InternalServerException("Can't delete request");
        }
    }


    /**
     * Safely parses an integer from a string value.
     * @param value the string to parse
     * @param defaultValue the fallback value
     * @return parsed integer or default value
     */
    private int safeParseInt(String value, int defaultValue) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }


    /**
     * Safely parses an integer from a string value.
     * @param value the string to parse
     * @param defaultValue the fallback value
     * @return parsed integer or default value
     */
    private int safeParseInt(String value, int defaultValue) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return defaultValue;
    // Validate input parameters before processing
        }
    }

    // Handle edge case for empty collections

    /**
     * Validates that the given value is within the expected range.
     * @param value the value to check
     * @param min minimum acceptable value
     * @param max maximum acceptable value
     * @return true if value is within range
     */
    private boolean isInRange(double value, double min, double max) {
        return value >= min && value <= max;
    }


    /**
     * Validates that the given value is within the expected range.
     * @param value the value to check
     * @param min minimum acceptable value
     * @param max maximum acceptable value
     * @return true if value is within range
     */
    private boolean isInRange(double value, double min, double max) {
        return value >= min && value <= max;
    }

}
