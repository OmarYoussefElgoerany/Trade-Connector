package com.tradeconnector.company_service.jobRequest;

import com.tradeconnector.company_service.common.PageResponse;
import com.tradeconnector.company_service.entities.JobRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class JobRequestService {
    private final JobRequestRepository jobReqRepo;
    private final JobRequestMapper jobReqMapper;

    public Integer Create(JobRequestRequest request) {
        JobRequest company = jobReqMapper.toJobRequest(request);
        return jobReqRepo.save(company).getId();
    }

    public JobRequestResponse findById(Integer compId) {
        return jobReqRepo.findById(compId)
                .map(jobReqMapper::toCompResponse)
                .orElseThrow(() -> new EntityNotFoundException("No JobReq found with ID:: " + compId));
    }
    public PageResponse<JobRequestResponse> getAllWithCompanyName(int page, int size) {
        if(page == 0){
            page = 1;
        }else if(size == 0){
            size = 1;
        }
        Pageable pageable = PageRequest.of(page - 1, size);
        Page<JobRequestResponse> jobReqPage = jobReqRepo.findAllWithCompanyName(pageable);

        return new PageResponse<>(
                jobReqPage.getContent(),
                jobReqPage.getNumber(),
                jobReqPage.getSize(),
                jobReqPage.getTotalElements(),
                jobReqPage.getTotalPages(),
                jobReqPage.isFirst(),
                jobReqPage.isLast()
        );
    }



    public boolean delete(Integer compId) {
        JobRequest comp = jobReqRepo.findById(compId)
                .orElseThrow(() -> new EntityNotFoundException("No jobReq found with ID:: " + compId));
        ;

        if (comp == null) {
            return false;
        }

        jobReqRepo.delete(comp);
        return true;
    }
    public JobRequestResponse update(JobRequestRequest jobReq) {
        JobRequest comp = jobReqRepo.findById(jobReq.id())
                .orElseThrow(() -> new EntityNotFoundException("No jobReq found with ID:: " + jobReq.id()));
        ;
        JobRequest jobRequest = jobReqMapper.toJobRequest(jobReq);
        if (comp == null) {
            return new JobRequestResponse();
        }

        jobReqRepo.save(jobRequest);

        return jobReqMapper.toCompResponse(jobRequest);
    }
}
