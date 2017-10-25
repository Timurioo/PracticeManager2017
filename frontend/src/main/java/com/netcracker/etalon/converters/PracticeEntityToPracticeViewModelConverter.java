package com.netcracker.etalon.converters;


import com.netcracker.etalon.beans.FacultyViewModel;
import com.netcracker.etalon.beans.HeadOfPracticeViewModel;
import com.netcracker.etalon.beans.PracticeViewModel;
import com.netcracker.etalon.beans.SpecialityViewModel;
import com.netcracker.pmbackend.impl.entities.PracticesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

public class PracticeEntityToPracticeViewModelConverter implements Converter<PracticesEntity, PracticeViewModel> {

    @Autowired
    private ConversionService conversionService;

    public PracticeViewModel convert(PracticesEntity practicesEntity) {
        PracticeViewModel practiceViewModel = new PracticeViewModel();
        practiceViewModel.setId(String.valueOf(practicesEntity.getId()));
        practiceViewModel.setCompany(practicesEntity.getCompany());
        practiceViewModel.setFirstDate(String.valueOf(practicesEntity.getFirstDate()));
        practiceViewModel.setFinishDate(String.valueOf(practicesEntity.getFinishDate()));
        practiceViewModel.setStatus(practicesEntity.getStatus());
        practiceViewModel.setTotalQuantity(String.valueOf(practicesEntity.getTotalQuantity()));
        practiceViewModel.setAvailableQuantity(String.valueOf(practicesEntity.getAvailableQuantity()));
        practiceViewModel.setHeadOfPracticeViewModel(conversionService.convert(practicesEntity.getHeadofpracticesByHeadofpracticeId(), HeadOfPracticeViewModel.class));

        if(practicesEntity.getFacultyId() != null){
            practiceViewModel.setFacultyViewModel(conversionService.convert(practicesEntity.getFacultyByFacultyId(), FacultyViewModel.class));
        }else{
            practiceViewModel.setFacultyViewModel(null);
        }

        if(practicesEntity.getSpecialityId() != null){
            practiceViewModel.setSpecialityViewModel(conversionService.convert(practicesEntity.getSpecialityBySpecialityId(), SpecialityViewModel.class));
        }else{
            practiceViewModel.setSpecialityViewModel(null);
        }

        if(practicesEntity.getAvrMark() != null){
            practiceViewModel.setAvrMark(String.valueOf(practicesEntity.getAvrMark()));
        }else{
            practiceViewModel.setAvrMark("");
        }


        return practiceViewModel;
    }
}
