# BeetRide Test Automation Summary Report

**Project**: BeetRide Driver & Rider App
**Framework**: Cucumber BDD + Appium + Java
**Date**: 2026-02-23

---

## Overall Summary

| Metric | Count | Percentage |
|--------|-------|------------|
| **Total Test Cases** | **351** | 100% |
| Passed | 143 | 40.74% |
| Failed | 8 | 2.28% |
| Pending (Not Implemented) | 200 | 56.98% |
| **Implemented (Pass + Fail)** | **151** | **43.02%** |

---

## Breakdown by App

### Driver App

| Metric | Count | Percentage |
|--------|-------|------------|
| **Total** | **117** | 100% |
| Passed | 96 | 82.05% |
| Failed | 7 | 5.98% |
| Pending | 14 | 11.97% |
| **Implemented** | **103** | **88.03%** |

### Rider App

| Metric | Count | Percentage |
|--------|-------|------------|
| **Total** | **234** | 100% |
| Passed | 47 | 20.09% |
| Failed | 1 | 0.43% |
| Pending | 186 | 79.49% |
| **Implemented** | **48** | **20.51%** |

---

## Failed Test Cases (8)

| TC ID | Module | Description | App |
|-------|--------|-------------|-----|
| TC-012 | Auto Price Ride | Rider rejects, auto ride in 5 minutes | Driver |
| TC-013 | Penalty Popup | Driver rejects 3 rides (6am-12pm) | Driver |
| TC-039 | Notifications | Notification list items/toggles | Rider |
| TC-040 | Notifications | Toggle notifications ON/OFF | Rider |
| TC-045 | Settings | Cannot confirm without selecting language | Rider |
| TC-072 | Ride Booking | Reopen app during searching | Rider |
| TC-075 | Ride Booking | Drop-off same as pickup | Rider |
| TC-140 | City to City | Validation: pickup = drop-off | Rider |

---

## Pass Rate Visualization

```
Overall:    [==================                              ] 40.74% (143/351)
Driver App: [=========================================       ] 82.05% (96/117)
Rider App:  [==========                                      ] 20.09% (47/234)
```

---

## Implementation Progress

```
Overall:    [=====================                           ] 43.02% (151/351)
Driver App: [============================================    ] 88.03% (103/117)
Rider App:  [==========                                      ] 20.51% (48/234)
```

---

## Summary

- **151 out of 351** test cases have been implemented and executed
- **143 test cases passed** with a **94.70% pass rate** among implemented tests
- **8 test cases failed** (5.30% of implemented)
- **200 test cases** are still pending implementation
- Driver App automation is **88.03% complete**
- Rider App automation is **20.51% complete**