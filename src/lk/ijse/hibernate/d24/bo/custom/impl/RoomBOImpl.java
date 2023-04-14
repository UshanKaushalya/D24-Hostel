package lk.ijse.hibernate.d24.bo.custom.impl;

import lk.ijse.hibernate.d24.bo.custom.RoomBO;
import lk.ijse.hibernate.d24.dto.RoomDTO;
import lk.ijse.hibernate.d24.entity.RoomEntity;
import lk.ijse.hibernate.d24.repository.RepositoryFactory;
import lk.ijse.hibernate.d24.repository.custom.RoomRepository;
import lk.ijse.hibernate.d24.repository.custom.impl.RoomRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

public class RoomBOImpl implements RoomBO {

    RoomRepository roomRepository = (RoomRepositoryImpl) RepositoryFactory.getRepositoryFactory().getRepository(RepositoryFactory.RepositoryTypes.ROOM);
    @Override
    public boolean saveRoom(RoomDTO roomDTO) {
        return roomRepository.save(new RoomEntity(
                roomDTO.getRoomTypeID(),
                roomDTO.getType(),
                roomDTO.getKeyMoney(),
                roomDTO.getQty(),
                new ArrayList<>()
        ));
    }

    @Override
    public boolean updateRoom(RoomDTO roomDTO) {
        return roomRepository.update(new RoomEntity(
                roomDTO.getRoomTypeID(),
                roomDTO.getType(),
                roomDTO.getKeyMoney(),
                roomDTO.getQty(),
                new ArrayList<>()
        ));
    }

    @Override
    public boolean deleteRoom(RoomDTO roomDTO) {
        return roomRepository.delete(new RoomEntity(
                roomDTO.getRoomTypeID(),
                roomDTO.getType(),
                roomDTO.getKeyMoney(),
                roomDTO.getQty(),
                new ArrayList<>()
        ));
    }

    @Override
    public RoomDTO searchRoom(String id) {
        RoomEntity room = roomRepository.search(id);

        return new RoomDTO(
                room.getRoomTypeId(),
                room.getKeyMoney(),
                room.getQty(),
                room.getType()
        );
    }

    @Override
    public int getRoomCount(String id) {
        return roomRepository.getRoomCount(id);
    }

    @Override
    public List<RoomDTO> getAllRooms() {
        List<RoomEntity> allRoomsEntity = roomRepository.getAll();

        List<RoomDTO> allRooms = null;

        for (int i = 0; i < allRoomsEntity.size(); i++) {
            allRooms.add(
                    new RoomDTO(
                            allRoomsEntity.get(i).getRoomTypeId(),
                            allRoomsEntity.get(i).getKeyMoney(),
                            allRoomsEntity.get(i).getQty(),
                            allRoomsEntity.get(i).getType()
                    )
            );
        }

        return allRooms;
    }
}
